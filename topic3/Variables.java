public class Variables
{
	int num1; // 멤버 변수이자 인스턴스 변수
	static int num2; // 멤버 변수이자 클래스 변수
	
	public void printName (String name) { // 여기서 name은 parameter
	    String prtMsg = name + " Hello!"; // 함수 내에서 지역 변수가 됨
	    System.out.println(prtMsg); 
	}
	
	public static void main (String[] args) {
	    // 인스턴스 생성
	    Variables mc = new Variables();
	    
	    mc.num1 = 100; // 인스턴스 변수 사용
	    Variables.num2 = 50;  // 클래스 변수 사용
	    
	    mc.printName("임규연");
	    
	    System.out.printf ("%d %d", mc.num1, Variables.num2);
	}
}