package learning_java;
import java.util.*;

public class topic4_1127_2 {
	public static void main(String[] args) {
		// for (초깃값; 조건식; 증감식)
		// for (타입 : 집합형 데이터)
		
		// 구구단을 for, 2차원 배열, while, do-while로 작성해보기
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d ", i * j);
			}
			System.out.println();
		}
		System.out.println("-----------");
		
		int[][] arr = new int[9][9];
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				arr[i-1][j-1] = i * j;
			}
		}
		
		for (int[] k : arr) {
			for (int p : k) {
				System.out.printf("%d ", p);
			}
			System.out.println();
		}
		
		System.out.println("-----------");

		
		int a = 1, b = 1;
		while (true) {
			if (a >= 10) {
				break;
			}
			
			while (true) {
				if (b >= 10) {
					b = 1; 
					break;
				}
				System.out.printf("%d ", a * b);
				b++;
			}
			
			System.out.println();
			a++;
		}
		
		System.out.println("-----------");

		
		int x = 1, y = 1;
		do {
			do {
				System.out.printf("%d ", x * y);
				y++;
			} while (y <= 9);
			System.out.println();
			y = 1;
			x++;
		} while (x <= 9);
	}
}
