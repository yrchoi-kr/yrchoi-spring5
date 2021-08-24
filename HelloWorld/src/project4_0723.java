import java.util.Scanner;

public class project4_0723 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("m:메뉴리스트, o:주문, s:매출현황, x:종료");
		String param1 = sc.nextLine();
		
//		while(!param1.equals("x")) {
//			switch(param1) {
//				case "m":
//					System.out.println("메뉴리스트");
//					break;
//				case "o":
//					System.out.println("주문");
//					break;
//				case "s":
//					System.out.println("매출 현황");
//					break;	
//				}	
//			param1 = sc.nextLine();	
//		}
		do {
			switch(param1) {
			case "m":
				System.out.println("메뉴리스트");
				break;
			case "o":
				System.out.println("주문");
				break;
			case "s":
				System.out.println("매출 현황");
				break;	
			}
		if(!param1.equals("x"))	
			param1 = sc.nextLine();	
		}
		while(!param1.equals("x"));
		System.out.println("프로그램 종료");
	}
}
