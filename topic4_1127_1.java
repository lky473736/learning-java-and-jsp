package learning_java;
import java.util.*;

// switch 문에서 람다식을 사용
// 람다식 사용 시에 블록이 한 줄 이상이면 리턴할 때 yield 사용함
// break 사용할 필요 없음

public class topic4_1127_1 {
	int token = 0;
	
	static Scanner scan = new Scanner(System.in);
	void login() {
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		
		System.out.println("비밀번호 입력 : ");
		String pw = scan.next();
		
		if (id.equals("lky") == true && pw.equals("0000")) {
			System.out.println("로그인 성공");
			token = 1;
		}
		else {
			System.out.println("아이디나 비밀번호가 틀림");
		}
	}
	
	void check() {
		if (token == 1) {
			int cnt = 10;
			String msg = cnt > 0 ? "새로운 쪽지 있음" : "새로운 쪽지 없음";
			System.out.println(msg);
		}
		else {
			System.out.println("로그인부터 하세요"); 
		}
	}
	
	public static void main(String[] args) {
		topic4_1127_1 con = new topic4_1127_1();
		while (true) {
			System.out.println("메뉴 선택");
			String sel = scan.next();
			
			switch(sel) {
			case "1" -> con.login();
			case "2" -> con.check();
			case "3" -> System.exit(0);
			default -> System.out.println("잘못 입력");
			}
		}
	}
}
