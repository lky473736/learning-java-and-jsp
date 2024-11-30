package kioskV1;
import java.util.*;

public class kioskAppV1 {
	boolean VALID = true; // 인스턴스 변수
	String selMenu; // 인스턴스 변수
	String optionSelect = ""; // 인스턴스 변수
	
	String[][] menu = {{"돈까스", "일반", "왕돈까스", "치즈가루"}, {"카레라이스", "보통", "맵게", "치킨"}};
	static Scanner scan = new Scanner(System.in);
	
	public void run() {
		showMenu();
		System.out.print("#메뉴 선택 : ");
		int sel = scan.nextInt();
		
		String[] menuOptions = new String[3];
		switch(sel) {
		case 1 -> {
			selMenu = menu[0][0];
			for (int i = 1; i < menu[0].length; i++) {
				menuOptions[i-1] = menu[0][i];
			}
		}
		case 2 -> {
			selMenu = menu[1][0];
			for (int i = 1; i < menu[1].length; i++) {
				menuOptions[i-1] = menu[1][i];
			}
		}
		default -> System.out.println("주문 불가능");
		}
		
		optionSelect(menuOptions);
		checkOrder();
		
		while (!checkOut()) {
			System.out.println("결제 실패");
			VALID = true;
		}
	}
	public void showMenu() {
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("[%d] %s\n", i+1, menu[i][0]);
		}
	}
	private void optionSelect(String[] options) {
		System.out.printf("%s 선택함 : 옵션 선택하기(콤마구분) : ", selMenu);
		for (int i = 0; i < options.length; i++) {
			System.out.printf("[%d]%s/", i, options[i]);
		}
		String input = scan.next();
		for (String sel : input.split(",")) {
			optionSelect += options[Integer.parseInt(sel)]+","; 
			// Integer.parseInt <-- 문자열을 숫자로 변환
			// 문자열 더할때는 +=로 해주면 되겠구나
		}
	}
	private void checkOrder() {
		System.out.printf("%s\n", selMenu);
		System.out.println(optionSelect);
	}
	private boolean checkOut() {
		if (VALID) {
			System.out.println("결제됨");
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		kioskAppV1 kiosk = new kioskAppV1();
		kiosk.run();
	}
}
