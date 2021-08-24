import java.util.Scanner;

public class project5_724 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("m:메뉴리스트, o:주문, s:매출현황, x:종료");
		String param1 = sc.nextLine();
		
		while(!param1.equals("x") && !param1.equals("m")) {
			System.out.println("m:메뉴리스트, o:주문, s:매출현황, x:종료");
		    param1 = sc.nextLine();
		}
		System.out.println("ffdf");
	}
}
