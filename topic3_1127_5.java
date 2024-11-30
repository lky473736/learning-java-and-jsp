package learning_java;
import java.util.*;

// 논리 연산자, 비트 연산자 연습

public class topic3_1127_5 {
	public static void main(String[] args) {
		if (!true) {
			System.out.println("여기 들어가면 말이 안됨");
		}
		
		else {
			System.out.println("정상임");
		}
		
		if (true && !false) {
			System.out.println("정상임");
		}
		
		if (true || false) {
			System.out.println("정상임");
		}
		
		int num1 = 10;
		System.out.printf("정수값 num1 : %d, %s\n", num1, Integer.toBinaryString(num1)); 
		
		num1 >>= 1; // 비트쉬프트 오른쪽하면 2씩 나눠짐
		System.out.printf("정수값 num1 : %d, %s\n", num1, Integer.toBinaryString(num1));
		
		num1 <<= 1; // 비트쉬프트 왼쪽이면 2씩 곱해짐
		System.out.printf("정수값 num1 : %d, %s\n", num1, Integer.toBinaryString(num1));
		
		int num2 = 11;
		int rst = 0;
		
		rst = num1 ^ num2;
		System.out.printf("%s %s %s\n", Integer.toBinaryString(num1), Integer.toBinaryString(num2), Integer.toBinaryString(rst));
		
		rst = num1 | num2;
		System.out.printf("%s %s %s\n", Integer.toBinaryString(num1), Integer.toBinaryString(num2), Integer.toBinaryString(rst));
	
		rst = num1 & num2;
		System.out.printf("%s %s %s\n", Integer.toBinaryString(num1), Integer.toBinaryString(num2), Integer.toBinaryString(rst));
	}
	
}
