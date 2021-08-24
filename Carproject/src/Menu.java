import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu { // 선언(정의) only. not 실행코드 
	private ArrayList<String> alName;
	private ArrayList<Integer> alPrice;
	//main 로직 내에서 close 선언 후 다시 Scanner 선언시 기존 Scanner의 값이 날아가는 것으로 보임
	//따라서 Menu 클래스 내부에  Static으로 Scanner를 정적 필드로 선언 하여 사용
	//아래는 이 Menu클래스를 기반하는 모든 인스턴스에서 공유하는 Scanner 필드 sc, sn 임
	static Scanner sc = new Scanner(System.in);
	static Scanner sn = new Scanner(System.in);
	Menu() {
		alName=new ArrayList<String>();
		alPrice=new ArrayList<Integer>();
		this.load();
//		addName("Americano");
//		addName("Espresso");
//		addName("Latte");
//		addPrice(2000);
//		addPrice(2500);
//		addPrice(3000);
//		
//		showMenu();
	}
	Menu(String menuName, int price){
		alName=new ArrayList<String>();
		alPrice=new ArrayList<Integer>();
		this.alName.add(menuName);
		this.alPrice.add(price);
		this.load();
	}
	/* 생성자 - 일종의 메소드
	 *         용도: 주로 초기화 작업용. 
	           명명법: 이름이 클래스와 같아야 함.
	           반환값: 반환값이 없다.(반환할 수 없이, 작업만 실행)
	           실행/호출: new연산자가 실행된 직후, 자동실행
	           다른 메소드/생성자를 호출할 수 있다.
	*/
	void addName(String name) {
		this.alName.add(name);
	}
	void addPrice(int price) {
		this.alPrice.add(price);
	}
	void addPrice(String price) {
		this.alPrice.add(Integer.parseInt(price));
	}
	void appendMenu() {
		//data 입력
		System.out.println("메뉴를 추가합니다.");
		System.out.println("이름을 입력해 주세요");
		String addMenu = sc.nextLine();
		System.out.println("가격을 입력해 주세요");
		String addPrice = sc.nextLine();
		//data set
		this.addName(addMenu);
		this.addPrice(addPrice);
	}
	void updateMenu2() {
		System.out.println("기존 메뉴 수정 이름/가격");
		System.out.println("수정할 메뉴의 인덱스를 입력해주세요");
		int index = sn.nextInt();
		System.out.println("수정할 메뉴의 이름을 입력해 주세요");
		String updateMenu = sc.nextLine();
		System.out.println("수정할 메뉴의 가격을 입력해 주세요");
		int updatePrice = sn.nextInt();
		//data update
		this.updateMenu(index,updateMenu);
		this.updatePrice(index,updatePrice);
	}
	void deleteMenu2() {
		//data 입력
		System.out.println("삭제할 메뉴의 인덱스를 입력해주세요 ");
		int index = sn.nextInt();
		//data delete
		this.deletMenu(index);
	}

	// alName, alPrice get set
	public ArrayList<String> getAlName() {
		return alName;
	}
	public void setAlName(ArrayList<String> alName) {
		this.alName = alName;
	}
	public ArrayList<Integer> getAlPrice() {
		return alPrice;
	}
	public void setAlPrice(ArrayList<Integer> alPrice) {
		this.alPrice = alPrice;
	}
	
	void showMenu() {
		for(int i=0;i<this.alName.size();i++) {
			System.out.println((i+1)+ " " +this.alName.get(i)+"\t"+this.alPrice.get(i));
		}
	}
	void deletMenu(int displayedIndex) {
		alName.remove(displayedIndex-1);
		alPrice.remove(displayedIndex-1);
	}
	void updateMenu(int displayedIndex,String name) {
		alName.set(displayedIndex-1,name);
	}
	void updatePrice(int displayedIndex,int price) {
		alPrice.set(displayedIndex-1,price);
	}
	String getName(int menu_num) {
		return this.alName.get(menu_num-1);
	}
	int getPrice(int menu_num) {
		return this.alPrice.get(menu_num-1);
	}
	void save() throws IOException { // arrayList alname, alPrice를 화일 (menu.txt)에 저장
		File file=new File("d:/menu.txt");
		if(file.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for(int i=0;i<this.alName.size();i++) {
					String line = this.alName.get(i)+","+this.alPrice.get(i);
					writer.write(line);
					if((i+1)!=this.alName.size())
						writer.write("\r\n");
				}
				writer.flush();
				writer.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	void load() { // 화일 (menu.txt)을 읽어서 arraylist alName, alPrice에 로드
		File file=new File("d:/menu.txt");
		if(file.exists()) {
			BufferedReader inFile = null;
			try {
				inFile = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line;
			try {
				line = inFile.readLine();
				while(line!=null) {
					String[] parts = line.split(",");
					addName(parts[0]);
					addPrice(parts[1]);
					line=inFile.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
