package learning_java;
import java.util.*;

public class topic4_1130_5 {
	static int pop = 0;
	
	public int daramji {
		System.out.println (switch(pop) {
		case 1 -> "1";
		case 2 -> "2";
		default -> "0";
		});
		return switch (pop) {
		case 1 -> 1;
		case 2 -> 2;
		defualt -> {
			System.out.println("3");
			yield 3;
		}
		}
	}
}
