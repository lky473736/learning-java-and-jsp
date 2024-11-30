package learning_java;
import java.util.*;

public class topic3_1126_1 {
	public static void main(String[] args) {
		int num1 = 10; // 원시자료형 정수
		String msg = "wow wow wow"; // 객체타입 문자열
		// Member member = new Member(); <-- 객체타입 Member class
		char c1 = 'A'; // 문자형 변수 선언 및 초기화
		char c2 = '\u0041'; // unicode로 'A' 표현함
		long num2 = 212355L; // long 형은 반드시뒤에 L이나 l 붙여줘야함
		float num3 = 13.4F; // float형은 반드시 뒤에 F나 f 붙여줘야함
		boolean result = true;
	}
}

/*
	변수
	- 자바는 원시자료형과 클래스타입을 모두 지원함 
		- 원시자료형에 대한 클래스 타입 == 래퍼클래스
		- 객체타입의 변수 == 참조변수
		- 클래스부에 선언된 변수 == 필드, 멤버변수
	- 자바는 정적 타입 언어
		- 파이썬이나 자바스크립트는 동적 타입 언어
	- 선언 방법
		- 접근제어자 타입 변수명
			- 접근제어자 : 변수 접근 범위를 지정함
			- 타입 : 명시적으로 타입을 지정
			- 변수명 
*/