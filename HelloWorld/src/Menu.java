import java.util.ArrayList;

public class Menu {
	private ArrayList<String> alName;
	private ArrayList<Integer> alPrice;
	void init() {
		this.alName=new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
	}
	void addName(String name) {
		this.alName.add(name);
	}
	void addPrice(String price) {
		//nextLine이랑 nextInt랑 번갈아 가며 썻더니 mismatch 오류 떠서
		//String으로 둘다 받은 후 여기서 형변환 해서 넣었습니다.
		int priceConvert = Integer.parseInt(price);
		this.alPrice.add(priceConvert);
	}
	String getLastName() {
		return this.alName.get(alName.size()-1);
	}
	ArrayList<String> getName() {
		return this.alName;
	}
	ArrayList<Integer> getPrice() {
		return this.alPrice;
	}
	void showMenu() {
		System.out.println("메뉴          가격");
		//alName으로 for문 조건문 작성 시 main에서 ""입력 받을 경우 price에는 
		//해당 i값이 존재하지 않아 outOfBound 오류 출력 조건에 alPrice만큼 까지 for문 돌도록 함
		for(int i=0;i<alPrice.size();i++) {
			System.out.println(alName.get(i)+"  "+alPrice.get(i));
		}
	}
	void save() { // arrayList alname, alPrice를 화일 (menu.txt)에 저장
		
	}
	void load() { // 화일 (menu.txt)을 읽어서 arraylist alName, alPrice에 로드
		
	}
	
}
