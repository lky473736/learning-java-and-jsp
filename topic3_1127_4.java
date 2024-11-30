package learning_java;
import java.util.*;

// 메소드 연습하기

public class topic3_1127_4 {
	static Scanner sc = new Scanner(System.in);
	static int oper1 = 0;
	static int oper2 = 0; //클래스 변수
	
	topic3_1127_4() {
		System.out.println("인스턴스를 만듦");
		if (oper1 == 0) { 
			System.out.println("oper1이 0임");
		}
		
		if (oper2 == 0) {
			System.out.println("oper2가 0임");
		}
	}
	
	int add() {
		System.out.println("인자 없는 add");
		return oper1 + oper2;
	}
	
	int add(int new_param) {
		System.out.println("인자가 하나 있는 add");
		System.out.println("뭐랑 더할거임?");
		System.out.println("oper1 : " + oper1);
		System.out.println("oper2 : " + oper2);
		
		int choose = sc.nextInt();
		switch (choose) {
			case 1 : { return oper1 + new_param; }
			case 2 : { return oper2 + new_param; }
			default : { return 0; }
		}
	}
	
	int add (int ...params) {
		System.out.println("인자가 많은 add");
		
		int tmp = 0;
		
		for (int k : params) {
			tmp += k;
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		topic3_1127_4 c = new topic3_1127_4();
		
		oper1 = 10;
		oper2 = 15;
		
		int s1 = c.add();
		int s2 = c.add(2);
		int s3 = c.add(1, 2, 3, 4, 5);
		
		System.out.printf("%d %d %d", s1, s2, s3);
	}
}
