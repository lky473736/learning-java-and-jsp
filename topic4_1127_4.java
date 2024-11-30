package learning_java;

import java.util.Scanner; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class topic4_1127_4 {
    public static void main(String[] args) {
        // 키보드 입력
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter your name: ");
            String name = scan.next(); // 문자열 입력
            System.out.print("Enter a number: ");
            int num = scan.nextInt();  // 정수 입력

            System.out.println("Name: " + name);
            System.out.println("Number: " + num);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scan.close(); // Scanner 닫기
        }

        // 로깅
        Logger logger = Logger.getLogger("mylogger");
        logger.info("Main program started");
        logger.log(Level.WARNING, "Data file size is too big");
    }
}


/*
	키보드 입력 
	- 프로그램 기본구조 : 입력 -> 처리 -> 출력
	- 자바에서 표준입력장치 : System.in
	- 표준출력 : System.out
	- Scanner : 입력 스트림으로 데이터 읽어옴 
		- 스트림 : 데이터 입출력 위한 일종의 통로, 파일과 연결된 스트림을 사용하면 파일로 데이터를 읽을 수도 있고, 네트워크로도 데이터를 읽을 수 있음
		- 키보드 이외 파일이나 네트워크도 Scanner로 입력 스트림 지정 가능함
		
	로깅
	- 프로그램에서 기록 위해 메세지 남기기
	- 로그 메세지를 따로 저장해놓는 것이 좋음 (서버 로그가 그에 대한 예시)
	- 그냥 System.out.println만 쓰기에는 체계적으로 기록 남기거나 관리하기 어려움
		- 해결책
			- log4j
			- logback
			- JDK 기본로거
*/