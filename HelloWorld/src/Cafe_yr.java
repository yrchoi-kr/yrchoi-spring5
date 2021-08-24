import java.util.Scanner;

public class Cafe_yr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		menu.init();
		
		menu.addName(sc.nextLine());
		while(!menu.getLastName().equals("")) {
			menu.addPrice(sc.nextLine());
			menu.addName(sc.nextLine());
		}
		menu.showMenu();
	}	

}