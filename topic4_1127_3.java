package learning_java;
import java.util.*;

public class topic4_1127_3 {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int scores1[] = {1, 2, 3, 4};
		int[] scores2 = {1, 2, 3, 4};
		int[] scores3 = new int[4]; // component의 타입과 크기만 미리 지정해둠
		
		// Arrays 클래스에 배열 다루기 위한 메소드 많음
		// Arrays의 클래스에 있는 모든 메소드가 static이라 인스턴스 생성 필요없음
		// 배열은 크기가 고정되어 있고 불편해서 asList로 list로 변경해야 하는게 좋음
		
		Integer[] nums = {4, 3, 1, 2}; 
		List<Integer> numsList = Arrays.asList(nums); // 정상 동작
		Arrays.sort(nums); // 정렬
		System.out.println(nums); // 이러면 ObjectID 출력됨
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.asList(nums));
		 
		Arrays.sort(nums, Collections.reverseOrder()); // 내림차순 정렬
		System.out.println(Arrays.toString(nums));

		Arrays.sort(nums, 0, 3); // 정렬하는데 0, 1, 2까지
		System.out.println(Arrays.toString(nums));
		
		Integer[] nums_copied = Arrays.copyOf(nums, nums.length);
		System.out.println(Arrays.toString(nums_copied));
	}
}

/*
	배열의 특징
	- 배열 선언 시 크기 지정하거나 초기 데이터로 크기 고정
	- 순차적으로 접근 -> 위치 모르면 효율 떨어짐
	- 배열에 들어가는 데이터는 모두 똑같은 자료형
	- 배열 중간에 추가하기 위해선 다른 값의 위치를 다 바꿔야함
	- 0부터 시작함
	- 배열명[인덱스]
	- 타입[] 변수명 or 타입 변수명[] 형식으로 선언
	- 배열.length로 배열의 크기 구할 수 있음.
*/