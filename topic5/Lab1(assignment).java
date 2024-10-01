/*
  과제 : 다차원 배열을 이용한 학생 성적 출력 프로그램 작성
    
    202334734 컴퓨터공학전공 임규연
*/

/*
    홍길동	90	85	91	266	88
    김사랑	92	95	88	275	91
    나대장	87	94	96	277	92
    
    형식으로 출력, 
    이름, 3과목의 점수를 공백으로 구분하여 입력
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
		String[] student = new String[3]; // 학생의 이름 저장 배열
		int[][] scores = new int[3][5]; // 학생의 이름마다 저장할 5개의 값 (Java, Python, C++, sum, avg)
		
	    for (int i = 0; i < student.length; i++) {
	        String name = scan.next();
	        int scoreJava = scan.nextInt();
	        int scorePython = scan.nextInt();
	        int scoreCpp = scan.nextInt();
	        
	        student[i] = name;
	        scores[i][0] = scoreJava;
	        scores[i][1] = scorePython;
	        scores[i][2] = scoreCpp;
	    }
	    
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            scores[i][3] += scores[i][j]; // 총합 계산
	        }
	        
	        scores[i][4] = scores[i][3] / 3; // 평균 계산
	    }
	    
	   System.out.println("\tJava\tPython\tC++\tsum\tavg"); // labeling
	    
	   for (int i = 0; i < 3; i++) {
	       System.out.print(student[i]); // 학생 이름 먼저 출력
	       
	       for (int j = 0; j < 5; j++) {
	           System.out.print('\t'); // 각 점수를 tab으로 구분하였다
	           System.out.print (scores[i][j]);
	       }
	       
	       System.out.println(); // 각 학생마다 개행
	   }
	}
}
