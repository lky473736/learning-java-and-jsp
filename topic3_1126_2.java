package learning_java;
import java.util.*;

public class topic3_1126_2 {
	int num1 = 0; // 멤버 변수이자 인스턴스 변수
	static int num2 = 0; // 멤버 변수이자 클래스 변수
	public void print (String name) { // parameter (매개변수)
		System.out.println(name);
	}
	public static void main(String[] args) {
		// 인스턴스를 생성한 것임 (new 연산 통해)
		topic3_1126_2 c = new topic3_1126_2();
		
		c.num1 = 10000; // 인스턴스 변수 
		topic3_1126_2.num2 = 100; // 클래스 변수
		// num2 = 100해도 됨
		
		c.print("daramji");
		System.out.printf("%d %d %d \n", c.num1, c.num2, topic3_1126_2.num2);
	}
}

/*
	변수
	- 멤버변수 : 클래스부에 선언된 변수
		- 인스턴스 변수 : 클래스가 인스턴스될 때 초기화되는 변수, 인스턴스를 통해서만 접근 가능
		- 매개변수 : 메소드에 parameter, 메소드 내에서는 지역변수로 사용됨
	- 지역변수 : 메소드 내에서 선언됨
		- 멤버변수랑 동일한 이름 가질 수 있지만 지역변수가 우선시됨
	- 클래스 변수 : static으로 선언된 변수, 인스턴스 생성없이 클래스이름.변수명으로 사용 가능함, main() 메소드에서 참조할 수 있음
*/