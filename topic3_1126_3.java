package learning_java;
import java.util.*;

public class topic3_1126_3 {
	String name; // 멤버 변수
	
	topic3_1126_3() { // 생성자는 현재 클래스명(=파일명)과 같게끔 이름을 구성 (python에서는 def __init__와 같은 역할)
		name = "wow wow wow";
		System.out.printf("생성자 작동함 %s\n", name);
	}
	
	// parameter가 없는 메소드
	void printname() {
		System.out.println("printname 작동함 " + name);
	}
	
	// 메소드 오버로딩
	void printname(String name_param) {
		System.out.println("printname 작동했는데 오버로딩한 놈이 작동함 " + name_param);
	}
	
	// ... 붙이면 가변인자, 배열로 들어옴
	void printnames (String ...name) {
		for (String s : name) {
			System.out.println("가변인자 printnames : " + s);
		}
	}
	
	public static void main(String[] args) {
		topic3_1126_3 c = new topic3_1126_3(); // 인스턴스 만들었으니깐 생성자가 작동될 것임
		c.printname();
		c.printname("lky");
		c.printnames("wow", "wow!", "wow?");
	}
}

/*
	메소드
	- 선언 방법 : 접근제어자 리턴타입 메소드명 (인자)
		- 접근제어자 : 메소드 접근 범위
		- 리턴타입 : 어떤 타입 리턴? (리턴 없으면 void)
		- 인자가 없어도 () 당연히 사용해야 함
	
	메소드 오버로딩 
	- 리턴값이나 인자가 다른 여러 메소드를 동일한 이름으로 선언
	- 이유 : 인자에 따라서 다른 동작 수행하게 하려고
	
	가변 인자
	- 인자 수가 유동적인 메소드
	- String... msg와 같이 가변적으로 인자가 들어올 수 있음
	- 배열
	
	생성자 메소드
	- 클래스가 인스턴스될 때 호출됨
	- 메소드 오버로딩으로 인해 여러 생성자가 있을 수 있음
*/