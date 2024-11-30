package learning_java; 
import java.util.*;

public class topic2_1126 { // 클래스 선언 (파일명과 동일하기 때문에 public으로 선언이 된다)
	// 멤버 변수 (attribute)
	String daramji = "daramji";
	int cnt = 0;
	static int wow = 0; // 클래스 변수임 (static 붙이면)
	int wow2 = 0;
	static int wow2_static = 0;
	
	public static void add(int a, int b) { // 메소드
		System.out.println(a + b);
	}
	
	public static void add_1 () {
		topic2_1126 c1 = new topic2_1126();
		c1.cnt++;
	}
	
	public static void add_1_wow() {
		wow++;
	}
	
	public static void main(String[] args) { // main 메소드
		System.out.println("이름: 임규연");
		System.out.println("소속: 가천대학교");
		System.out.println("전공: 컴퓨터공학전공"); 
		System.out.println("학번: 202334734");
		
		add(19, 1); // 메소드를 사용 
		topic2_1126 c2 = new topic2_1126();
		System.out.println(c2.cnt);
		add_1();
		System.out.println(c2.cnt); 
		
		// 클래스부에서 선언된 변수 이용하기 위해선 인스턴스 변수를 이용하거나, 클래스 변수를 이용하거나
		topic2_1126 c3 = new topic2_1126();
		System.out.println(c3.wow2);
		System.out.println(wow2_static);
		c3.wow2 = 10;
		System.out.println(c3.wow2);
		System.out.println(wow2_static);
		
		// cnt가 변경되지 않는 이유 : 독립적인 클래스를 구성하였기 때문에
		// 멤버변수에 접근하기 위해선? -> static으로
		
		System.out.println(wow);
		add_1_wow();
		System.out.println(wow);
	}
}

/*
	클래스의 기본 요소 : 변수와 메소드
	클래스 
	- 클래스 이름 == 소스 파일명
	- 하나의 소스 파일에 여러 클래스 선언 가능함
	- 단, public으로 선언된 클래스는 하나만 존재, 파일명과 동일한 클래스가 public으로 선언되어야 함
	
	인스턴스
	- main() 메소드는 단지 프로그램 실행하기 위한 진입점의 역할을 지니고, 실제 클래스 사용 위해 new() 연산으로 인스턴스 실행해야 함
	- main()에서 클래스부에 선언된 멤버변수를 접근할 수 없음 -> 인스턴스 통해 사용
	
	변수
	- 클래스 구성 요소로 객체 속성 나타냄 : 멤버변수
		- 인스턴스 생성시 초기화, 인스턴스 통해서만 사용 가능함
	- 메소드 내에 선언되는 변수 : 지역변수
	- 메소드에 전달되는 변수 : 매개변수
	- static으로 선언된 변수는 클래스 변수로 인스턴스 생성없이 사용 가능
	
	메소드
	- 함수랑 차이점 : 모듈화
		- 함수는 단순한 기능의 모듈화
		- 하지만 메소드는 객체의 동작을 정의
	- 동일한 이름의 메소드를 여러개 선언 가능 : 오버로딩
	- 상속받은 부모 클래스의 메소드는 자식 클래스에서 오버라이딩 가능
*/

/*
public class daramji  { // 한 파일에 public class는 하나씩
	
}*/