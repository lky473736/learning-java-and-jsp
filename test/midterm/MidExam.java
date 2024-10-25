/*
    JAVA (13979_002) 중간고사 프로젝트 : 나만의 SQL, LimSQL 
    - 사용자-컴퓨터 인터렉티브한 DB환경을 구축 (대화형 인터페이스의 도입)
    - 자바 기초문법1, 기초문법2에 언급되어 있는 문법으로만 구성 + equals와 parseDouble 사용 
        - "간단한 체크나 문자-숫자 변환등 사용 가능" -> equals와 parseDouble로 값 비교 시 사용하였음
    
    202334734 컴퓨터공학전공 임규연
    
    제출일자 : 2024.10.25.
    프로젝트 진행일자 : 2024.10.21. ~ 2024.10.25.
*/

import java.util.Scanner;

public class MidExam {
    static int MAX_USERS = 10; // 최대 사용자 수
    static int MAX_TABLES = 2; // 최대 테이블 수
    static int MAX_ROWS = 100; // 테이블당 최대 행 수
    static int MAX_COLS = 10;  // 테이블당 최대 열 수
    static String VERSION = "1.0.0"; // 시스템 버전 (처음 버전이니깐 1.0.0으로 지정해놓음)
    static String DEVELOPER = "임규연 (lky473736)"; // 개발자 임규연
    static String EMAIL = "lky473736@icloud.com"; // 이메일 주소
    static String GITHUB = "https://github.com/lky473736"; // 깃허브 주소

    static String[][][] tables = new String[MAX_TABLES][MAX_ROWS][MAX_COLS];  // 테이블 데이터 저장소
    static String[] tableNames = new String[MAX_TABLES]; // 테이블 이름 저장
    static String[][] columnNames = new String[MAX_TABLES][MAX_COLS];  // 열(속성) 이름 저장
    static int[] tableCols = new int[MAX_TABLES];  // 각 테이블의 열 개수
    static int[] tableRows = new int[MAX_TABLES];  // 각 테이블의 행 개수
    
    static String[] users = new String[MAX_USERS]; // 사용자 이름 저장
    static String[] passwords = new String[MAX_USERS];  // 사용자 비밀번호 저장
    static int userCount = 0;  // 현재 사용자 수 (추후에 handleAbout 함수에서 다룸)
    static int currentTableCount = 0;  // 현재 테이블 수(추후에 handleAbout 함수에서 다룸))
    
    static boolean exit = false; // exit token (나중에 사용자가 EXIT 입력 시 true로 변함)
    // exit은 일종의 flag 변수임

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("********************************************************");
        System.out.println("*                  LimSQL v1.0                          *");
        System.out.println("*           Welcome to the LimSQL monitor              *");
        System.out.println("*           202334734 컴퓨터공학전공 임규연             *");
        System.out.println("*  for 가천대학교 컴퓨터공학전공 JAVA 중간고사 프로젝트  *");
        System.out.println("* Type 'HELP' for help                                *");
        System.out.println("* Type 'ABOUT' for additional information             *");
        System.out.println("* Type 'EXIT' to exit                                 *");
        System.out.println("********************************************************");
        
        while(true) {
            if (exit == true) { // 만약 사용자가 EXIT 입력하면
                break;
            }
            
            System.out.print("LimSQL> ");
            String command = scan.next();
            
            switch (command) {
                case "SELECT":
                    handleSelect(scan);
                    break;
                case "DELETE":
                    handleDelete(scan);
                    break;
                case "UPDATE":
                    handleUpdate(scan);
                    break;
                case "INSERT":
                    handleInsert(scan);
                    break;
                case "DROP":
                    handleDrop(scan);
                    break;
                case "SHOW":
                    handleShow(scan);
                    break;
                case "CREATE":
                    handleCreate(scan);
                    break;
                case "DESC":
                    handleDesc(scan);
                    break;
                case "ABOUT":
                    handleAbout();
                    break;
                case "EXIT":
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                case "HELP":
                    handleHelp();
                    break;
                case "EASTER":
                    handleEaster();
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다. 다시 입력하세요. : " + command);
                    break;
                }
        }
        
        System.out.println("bye bye! 다음에 또 봅시다.");
    }
    
    static void handleEaster() {
        String[] cow = {
            " '(___)", 
            " (o o)____/",
            "  @@      \\",
            "   \\______,/",
            "   //   //",
            "  ^^   ^^'"
        };

        for (String line : cow) {
            System.out.println(line);
        }
        
        System.out.println("작은 행복, 행복소(小)를 그렸습니다. 작게 웃으면서 소박하게 살아갑시다. 오늘도 화이팅!");
    }
    
    static void handleHelp() {
        System.out.println("사용 가능한 명령어:");
        System.out.println("1. 데이터베이스 관리");
        System.out.println("   CREATE");
        System.out.println("   DROP");
        System.out.println("   SHOW");
        System.out.println("   DESC");
        System.out.println("2. 데이터 관리");
        System.out.println("   SELECT");
        System.out.println("   INSERT");
        System.out.println("   UPDATE");
        System.out.println("   DELETE");
        System.out.println("3. 사용자 관리");
        System.out.println("   CREATE");
        System.out.println("   DROP");
        System.out.println("   SHOW");
        System.out.println("4. 기타");
        System.out.println("   ABOUT");
        System.out.println("   EXIT");
    }

    // SELECT
    static void handleSelect(Scanner scan) {
        System.out.print("어느 테이블에서 검색하시겠습니까? ");
        String tableName = scan.next();
        int tableIndex = findTable(tableName);
        
        if (tableIndex == -1) { // 테이블을 못 찾았다면?
            System.out.println("해당 테이블을 찾을 수 없습니다");
            return;
        }
    
        System.out.print("모든 열을 선택하시겠습니까? (y/n): ");
        String allCols = scan.next();
        
        // WHERE 조건 처리
        String whereColumn = null;
        String operator = null;
        String whereValue = null;
        
        if (allCols.equals("n")) { // 모든 열 선택 안 함
            System.out.print("검색할 열의 갯수를 입력하세요: ");
            int cntColForSearch = scan.nextInt();
            
            String[] selectedCols = new String[cntColForSearch]; 
    
            System.out.print("검색할 열 이름을 입력하세요 (공백으로 구분): ");
            
            for (int i = 0; i < cntColForSearch; i++) {
                selectedCols[i] = scan.next(); 
            }
            
            System.out.print("WHERE 조건을 입력하시겠습니까? (y/n): ");
            String whereChoice = scan.next();
            
            if (whereChoice.equals("y")) { // WHERE 조건 선택함
                System.out.print("열 이름, 연산자(=, !=, > 등), 값을 입력하세요: ");
                whereColumn = scan.next();
                operator = scan.next();
                whereValue = scan.next();
            }
    
            int[] colIndexes = new int[selectedCols.length];
            
            for (int i = 0; i < selectedCols.length; i++) {
                colIndexes[i] = findColumn(tableIndex, selectedCols[i]);
                
                if (colIndexes[i] == -1) {
                    System.out.println("열을 찾을 수 없습니다: " + selectedCols[i]);
                    return;
                }
            }
            
            // 테이블 출력 헤더 (선택된 열만)
            printSelectedTableHeader(tableIndex, colIndexes);
            
            // 선택된 열과 WHERE 조건에 맞는 데이터를 출력한다
            for (int i = 0; i < tableRows[tableIndex]; i++) {
                boolean match = true;
                
                if (whereColumn != null) {
                    int whereColIndex = findColumn(tableIndex, whereColumn);
                    if (whereColIndex != -1) {
                        match = compareValues(tables[tableIndex][i][whereColIndex], operator, whereValue);
                    }
                }
                
                if (match) { // true이면 출력함
                    for (int colIndex : colIndexes) {
                        System.out.print(tables[tableIndex][i][colIndex] + "\t| ");
                    }
                    System.out.println();
                }
            }
        } else {
            // 모든 열 출력
            printTableHeader(tableIndex);
            
            for (int i = 0; i < tableRows[tableIndex]; i++) {
                for (int j = 0; j < tableCols[tableIndex]; j++) {
                    System.out.print(tables[tableIndex][i][j] + "\t| ");
                }
                System.out.println();
            }
        }
    }
    
    // 선택된 열 헤더 출력
    static void printSelectedTableHeader(int tableIndex, int[] colIndexes) {
        for (int colIndex : colIndexes) {
            System.out.print(columnNames[tableIndex][colIndex] + "\t| ");
        }
        System.out.println();
        for (int colIndex : colIndexes) {
            System.out.print("----------");
        }
        System.out.println();
    }
    
    // 테이블 헤더 (시각화)
    static void printTableHeader(int tableIndex) {
        for (int j = 0; j < tableCols[tableIndex]; j++) {
            System.out.print(columnNames[tableIndex][j] + "\t| ");
        }
        System.out.println();
        for (int j = 0; j < tableCols[tableIndex]; j++) {
            System.out.print("----------");
        }
        System.out.println();
    }


    // DELETE
    static void handleDelete(Scanner scan) {
        System.out.print("어느 테이블에서 삭제하시겠습니까? ");
        String tableName = scan.next();
        int tableIndex = findTable(tableName);
        
        if (tableIndex == -1) {
            System.out.println("해당 테이블을 찾을 수 없습니다");
            return;
        }
    
        System.out.print("WHERE 조건을 입력하세요 (열 연산자 값): ");
        String column = scan.next();
        String operator = scan.next();
        String value = scan.next();
        
        int colIndex = findColumn(tableIndex, column);
        if (colIndex == -1) { // 열 중에서 사용자가 입력한 열의 이름이 없다면?
            System.out.println("해당 열을 찾을 수 없습니다");
            return;
        }
    
        boolean found = false; // token 
        for (int i = 0; i < tableRows[tableIndex]; i++) {
            if (compareValues(tables[tableIndex][i][colIndex], operator, value)) {
                // 삭제된 행 출력
                System.out.print("삭제된 행: ");
                for (int j = 0; j < tableCols[tableIndex]; j++) {
                    System.out.print(tables[tableIndex][i][j] + "\t");
                }
                
                System.out.println();
    
                // 행 삭제하면 뒤에 있는 component를 앞으로 당겨온다.
                // 그니깐 0, 1, 2, 3, 4 이렇게 있을 때 중간에 2가 삭제 시 2의 빈공간을 3, 4가 채우기 위해
                // 앞에서부터 자리를 당겨온다.
                for (int j = i; j < tableRows[tableIndex] - 1; j++) {
                    for (int k = 0; k < tableCols[tableIndex]; k++) {
                        tables[tableIndex][j][k] = tables[tableIndex][j + 1][k];
                    }
                }
                
                tableRows[tableIndex]--;
                i--; 
                found = true;
            }
        }
    
        if (!found) { // 조건에 맞는 행이 없다면?
            System.out.println("조건에 맞는 행이 없습니다.");
        } 
        
        else {
            System.out.println("삭제가 완료되었습니다");
        }
    }

    // UPDATE 
    static void handleUpdate(Scanner scan) {
        System.out.print("어느 테이블을 수정하시겠습니까? ");
        String tableName = scan.next();
        int tableIndex = findTable(tableName);
        
        if (tableIndex == -1) { // 사용자가 입력한 테이블이 없다면?
            System.out.println("해당 테이블을 찾을 수 없습니다");
            return;
        }
    
        System.out.print("SET 조건을 입력하세요 (열 = 새값): ");
        String setColumn = scan.next();
        scan.next(); // = 기호 건너뛰기 (열과 새값만 받는 것이다)
        String newValue = scan.next();
        
        System.out.print("WHERE 조건을 입력하세요 (열 연산자 값): ");
        String whereColumn = scan.next();
        String operator = scan.next();
        String value = scan.next();
        
        int setColIndex = findColumn(tableIndex, setColumn);
        int whereColIndex = findColumn(tableIndex, whereColumn);
        
        if (setColIndex == -1 || whereColIndex == -1) {
            System.out.println("해당 열을 찾을 수 없습니다");
            return;
        }
    
        int updateCount = 0; // 조건에 맞게끔 UPDATE된 행 갯수 출력하기
        for (int i = 0; i < tableRows[tableIndex]; i++) {
            if (compareValues(tables[tableIndex][i][whereColIndex], operator, value)) {
                // 업데이트 전 값 출력
                
                System.out.print("업데이트 전: ");
                System.out.print(tables[tableIndex][i][setColIndex] + "\t");
    
                tables[tableIndex][i][setColIndex] = newValue;
                updateCount++;
    
                // 업데이트 후 값 출력
                System.out.println(" -> 업데이트 후: " + tables[tableIndex][i][setColIndex]); 
                // 업데이트 전과 업데이트 후값을 ->을 가운데에 두고 출력하여 어디가 변경되었는지 보기 쉽게 하였다.
            }
        }
        
        System.out.println(updateCount + "개의 행이 수정되었습니다");
    }


   // INSERT
    static void handleInsert(Scanner scan) {
        System.out.print("어느 테이블에 삽입하시겠습니까? ");
        String tableName = scan.next();
        int tableIndex = findTable(tableName);
        
        if (tableIndex == -1) { // 사용자가 입력한 테이블이 없다면?
            System.out.println("해당 테이블을 찾을 수 없습니다");
            return;
        }
    
        if (tableRows[tableIndex] >= MAX_ROWS) { // 만약 테이블의 최대행갯수에 도달했다면
            System.out.println("테이블이 가득 찼습니다");
            return;
        }
    
        System.out.println("현재 존재하는 행의 개수: " + tableRows[tableIndex]);
        System.out.print("열 이름: ");
        
        for (int i = 0; i < tableCols[tableIndex]; i++) {
            System.out.print(columnNames[tableIndex][i] + " ");
        }
        System.out.println();
    
        System.out.print("입력할 값들을 입력하세요 (공백으로 구분): ");
        scan.nextLine(); // 버퍼 비우기
        String[] values = new String[tableCols[tableIndex]]; 
        
        for (int i = 0; i < tableCols[tableIndex]; i++) {
            values[i] = scan.next();
        }
        
        if (values.length != tableCols[tableIndex]) { // 입력갯수 != 열갯수
            System.out.println("입력된 값의 개수가 열의 개수와 일치하지 않습니다");
            return;
        }
    
        for (int i = 0; i < values.length; i++) {
            tables[tableIndex][tableRows[tableIndex]][i] = values[i];
        }
        
        tableRows[tableIndex]++;
        System.out.println("데이터가 성공적으로 삽입되었습니다");
    }
    

    // CREATE
    static void handleCreate(Scanner scan) {
        System.out.print("테이블 생성 또는 사용자 생성? (t/u): ");
        String type = scan.next();
        
        if (type.equals("t")) { // table 생성
            if (currentTableCount >= MAX_TABLES) {
                System.out.println("최대 테이블 개수에 도달했습니다");
                return;
            }

            System.out.print("테이블 이름을 입력하세요: ");
            String tableName = scan.next();
            
            if (findTable(tableName) != -1) { // 이미 테이블 이름이 존재한다면?
                System.out.println("이미 존재하는 테이블 이름입니다");
                return;
            }

            System.out.print("열의 개수를 입력하세요: ");
            int colCount = scan.nextInt();
            
            if (colCount > MAX_COLS) { // 열갯수가 최대생성열갯수보다 많으면?
                System.out.println("열의 개수가 너무 많습니다");
                return;
            }

            tableNames[currentTableCount] = tableName;
            tableCols[currentTableCount] = colCount;
            tableRows[currentTableCount] = 0;

            System.out.println("열 이름들을 입력하세요:");
            for (int i = 0; i < colCount; i++) {
                columnNames[currentTableCount][i] = scan.next();
            }

            currentTableCount++;
            System.out.println("테이블이 성공적으로 생성되었습니다");
        } 
        
        else if (type.equals("u")) { // 사용자 생성
            if (userCount >= MAX_USERS) {
                System.out.println("최대 사용자 수에 도달했습니다");
                return;
            }

            while (true) {
                System.out.print("사용자 이름을 입력하세요: ");
                String username = scan.next();
                
                if (findUser(username) != -1) {
                    System.out.println("이미 존재하는 사용자 이름입니다");
                    continue;
                }

                System.out.print("비밀번호를 입력하세요: ");
                String password = scan.next();
                
                users[userCount] = username;
                passwords[userCount] = password;
                userCount++;
                
                System.out.println("사용자가 성공적으로 생성되었습니다");
                
                break;
            }
        }
    }

    // SHOW 
    static void handleShow(Scanner scan) {
        System.out.print("사용자 목록 또는 테이블 목록? (u/t): ");
        String type = scan.next();
        
        if (type.equals("u")) { // 사용자 목록
            System.out.println("사용자 목록:");
            for (int i = 0; i < userCount; i++) {
                System.out.println(users[i]);
            }
        } 
        
        else if (type.equals("t")) { // 테이블 목록
            System.out.println("테이블 목록:");
            for (int i = 0; i < currentTableCount; i++) {
                System.out.print(tableNames[i] + " (");
                for (int j = 0; j < tableCols[i]; j++) {
                    System.out.print(columnNames[i][j]);
                    if (j < tableCols[i] - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
        }
    }

    // DROP
    static void handleDrop(Scanner scan) {
        System.out.print("테이블 삭제 또는 사용자 삭제? (t/u): ");
        String type = scan.next();
        
        if (type.equals("t")) { // 테이블 삭제
            System.out.print("삭제할 테이블 이름: ");
            String tableName = scan.next();
            int tableIndex = findTable(tableName);
            
            if (tableIndex == -1) {
                System.out.println("해당 테이블을 찾을 수 없습니다");
                return;
            }

            // 테이블 제거 및 데이터 정리
            for (int i = tableIndex; i < currentTableCount - 1; i++) {
                tableNames[i] = tableNames[i + 1];
                tableCols[i] = tableCols[i + 1];
                tableRows[i] = tableRows[i + 1];
                
                for (int j = 0; j < MAX_COLS; j++) {
                    columnNames[i][j] = columnNames[i + 1][j];
                }
                for (int j = 0; j < MAX_ROWS; j++) {
                    for (int k = 0; k < MAX_COLS; k++) {
                        tables[i][j][k] = tables[i + 1][j][k];
                    }
                }
            }
            currentTableCount--;
            System.out.println("테이블이 성공적으로 삭제되었습니다");
        } 
        
        else if (type.equals("u")) { // 사용자 삭제
            System.out.print("삭제할 사용자 이름: ");
            String username = scan.next();
            int userIndex = findUser(username);
            
            if (userIndex == -1) {
                System.out.println("해당 사용자를 찾을 수 없습니다");
                return;
            }

            // 사용자 제거 및 데이터 정리
            for (int i = userIndex; i < userCount - 1; i++) {
                users[i] = users[i + 1];
                passwords[i] = passwords[i + 1];
            }
            userCount--;
            System.out.println("사용자가 성공적으로 삭제되었습니다");
        }
    }

    // DESC  (설명하기)
    static void handleDesc(Scanner scan) {
        System.out.print("어느 테이블을 설명하시겠습니까? ");
        String tableName = scan.next();
        int tableIndex = findTable(tableName);
        
        if (tableIndex == -1) { 
            System.out.println("해당 테이블을 찾을 수 없습니다");
            return;
        }

        System.out.println("테이블 이름: " + tableNames[tableIndex]);
        System.out.println("행 개수: " + tableRows[tableIndex]);
        System.out.println("열 개수: " + tableCols[tableIndex]);
        System.out.println("열 구조:");
        for (int i = 0; i < tableCols[tableIndex]; i++) {
            System.out.println("- " + columnNames[tableIndex][i]);
        }
    }

    // ABOUT (정보 출력)
    static void handleAbout() {
        System.out.println("=== LimSQL 시스템 정보 ===");
        System.out.println("버전: " + VERSION);
        System.out.println("개발자: " + DEVELOPER);
        System.out.println("이메일: " + EMAIL);
        System.out.println("GitHub: " + GITHUB);
        System.out.println("최대 테이블 개수: " + MAX_TABLES);
        System.out.println("현재 테이블 개수: " + currentTableCount);
        System.out.println("테이블당 최대 행 개수: " + MAX_ROWS);
        System.out.println("테이블당 최대 열 개수: " + MAX_COLS);
        System.out.println("최대 사용자 수: " + MAX_USERS);
        System.out.println("현재 사용자 수: " + userCount);
        
        // 이스터에그 힌트 (행복소 HAPPY COW)
        System.out.println("프롬프트에 'EASTER'라고 입력해보세요! 기분이 좋아질 거예요.");
    }

    /*
        아래부터는 위 사용자 지정 함수에서 사용한 일종의 "유틸리티"를 정의해놓은 것이다
    */
    
    static int findTable(String tableName) {
        for (int i = 0; i < currentTableCount; i++) {
            if (tableNames[i].equals(tableName)) {
                return i;
            }
        }
        return -1;
    }

    static int findUser(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }

    static int findColumn(int tableIndex, String columnName) {
        for (int i = 0; i < tableCols[tableIndex]; i++) {
            if (columnNames[tableIndex][i].equals(columnName)) {
                return i;
            }
        }
        return -1;
    }

    static boolean compareValues(String value1, String operator, String value2) {
        switch (operator) {
            case ">":
                return Double.parseDouble(value1) > Double.parseDouble(value2);
            case "<":
                return Double.parseDouble(value1) < Double.parseDouble(value2);
            case "=":
                return value1.equals(value2);
            case "!=":
            case "<>":
                return !value1.equals(value2);
            case ">=":
                return Double.parseDouble(value1) >= Double.parseDouble(value2);
            case "<=":
                return Double.parseDouble(value1) <= Double.parseDouble(value2);
            default:
                return false;
        }
    }
}
