import java.io.IOException;
import java.util.Scanner;

public class ChoiCafe {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Scanner sn= new Scanner(System.in);
		SalesReport sales = new SalesReport();
		String menu1;
		do {
			System.out.println("m:메뉴관리, o:메뉴 주문, s:실적, x:프로그램 종료");
			menu1 = sc.nextLine();
			switch(menu1) {
			case "m": 
				Menu menu=new Menu();
				System.out.println("메뉴를 관리 화면입니다."); 
				menu.showMenu();
				//CRUD (추가/읽기/수정/삭제)
				String menuOption;
				do {
					System.out.println("메뉴작업을 선택하시오(c:추가,r:목록보기,u:수정,d:삭제,q:메뉴작업 종료)"); 
					menuOption = sc.nextLine();
					switch(menuOption) {
					case "c": 
						menu.appendMenu();
						break; 
					case "r": 
						//data 입력
						System.out.println("목록 입니다.");
						//data read
						menu.showMenu();
						break; 
					case "u": 
						//data 입력
						menu.updateMenu2();						
						break;
					case "d": 
						menu.deleteMenu2();
					}		
				}
				while(!menuOption.equals("q"));
				menu.save();
				break;
				
			case "o":	
				Order order = new Order();
				order.showMenu();
				//값을 읽는다. 
				//oMI = Order Menu Index
				String oMI;
				//출력 "메뉴번호를 선택하세요"
				System.out.println("메뉴번호를 선택하세요"); 
				oMI = sc.nextLine();
				//메뉴 번호가 ""이 아닌동안
				boolean check = true;
				while(check) {
					int sumAll = 0;
					int indexWhile = 0;
					int sumParam = 0;
					while(!oMI.equals("")) {
						//출력 "수량을 입력하세요"
						//oMI = Order Menu Index (String)
						System.out.println(order.getName(Integer.parseInt(oMI))+"를 선택 하셨습니다. 수량을 입력하세요"); 
						//값을 읽는다.
						int cnt = sn.nextInt();
						//주문을 order에 추가 (oerder.addorder(메뉴명,수량);)
						//oMI = Order Menu Index
						int sum = order.addOrder(oMI,cnt);
						//계산해서 현재 음료의 총액 출력
						
						System.out.println(order.getName(Integer.parseInt(oMI))+"는 각 "+order.getPrice(Integer.parseInt(oMI))+"원 입니다." +cnt+" 개의 총액은 :"+sum+"원");
						sales.saveSalery();
						//계산해서 총액 출력
						sumParam += sum;
						System.out.println("현재까지 총액은"+sumParam+"원"+"\r\n");
						order.showMenu();
						//출력 "메뉴번호를 선택하세요"
						System.out.println("메뉴번호를 선택하세요"); 
						oMI = sc.nextLine();
						indexWhile++;
					} 
					// 전체 총액: 999999
					sumAll = order.getTotalSum(indexWhile);
					// 각 메뉴의 총액을 더한 전체 총액 출력
					System.out.println("전체 총액:" + sumAll);
					// 출력 "모바일 번호를 입력하세요"
					System.out.println("모바일 번호를 입력하세요");
					String mobileNum = sc.nextLine();
					// 주문고객의 모바일 번호 입력받는다.
					//System.out.println(indexWhile);
					order.getMobileNum(mobileNum,indexWhile);
					sales.saveMobileNum(mobileNum,indexWhile);
					// 실적에 추가한다.(나중에)
					check = false;
				}
				order.showOrderList();
				sales.saveReport();
				break;
			
			case "s": 
				System.out.println("실적 입니다."); 
				sales.showSalery();
				break;
			}
		} while(!menu1.equals("x"));
		System.out.println("프로그램 종료 합니다.");
		sc.close();sn.close();
	}
}



