import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalesReport extends Order {
	ArrayList<String> spMobile;
	ArrayList<String> spMenu;
	ArrayList<Integer> spCount;
	ArrayList<Integer> spTotal;
	ArrayList<Integer> spPriceO;
	SalesReport(){
		spMobile = new ArrayList<String>();
		spMenu = new ArrayList<String>();
		spCount = new ArrayList<Integer>();
		spTotal = new ArrayList<Integer>();
		spPriceO = new ArrayList<Integer>();
	
	}
	void saveSalery() {
		//주문메뉴명 추가
		System.out.println("alMenu size" +getalMenuSize());
		int index = getalMenuSize();
		String orderedMenu = getMenu(index);
		spMenu.add(orderedMenu);
		//주문 수량 추가
		int orderedCount = getalCount(index);
		spCount.add(orderedCount);
		//주문 가격 추가
		int orderedPrice = getalPriceO(index);
		spPriceO.add(orderedPrice);
		int totalPrice = getalTotal(index);
		spTotal.add(totalPrice);
	}
	void saveMobileNum(String num, int index) {
		if(spMobile.size() > 0) {	
			for(int i=index;i<this.spMenu.size();i++) {
				spMobile.add(num);
			}	
		}else {
			for(int i=0;i<this.spMenu.size();i++) {
				spMobile.add(num);
			}
		}
	}
	int saveTotalSalery() {
		//주문리스트의 총액을 모두 더해서 합계를 반환
		int sumAll = 0;
		for(int i=0;i<this.spMenu.size();i++) {
			sumAll += this.spTotal.get(i);
		}
		return sumAll;
	}
	void showSalery() {
		//작업 확인용
		System.out.println("제품\t단위가격\t갯수\t가격총\t모바일번호");
		for(int i=0;i<this.spMenu.size();i++) {
			System.out.println((i+1)+ " " +this.spMenu.get(i)+"\t"+this.spPriceO.get(i)+"\t"+this.spCount.get(i)+"\t"+this.spTotal.get(i)+"\t"+this.spMobile.get(i));
		}
		System.out.println("총 매출 :"+this.saveTotalSalery());
	}
	
	void saveReport() throws IOException { // arrayList alname, alPrice를 화일 (menu.txt)에 저장
		File file=new File("d:/salesReport.txt");
		if(file.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.newLine();
				for(int i=0;i<this.spMenu.size();i++) {
					String line = this.spMenu.get(i)+","+this.spPriceO.get(i)+","+this.spCount.get(i)+","+this.spTotal.get(i)+","+this.spMobile.get(i);
					writer.write(line);
					if((i+1)!=this.spMenu.size())
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
	void loadReport() { // 화일 (menu.txt)을 읽어서 arraylist alName, alPrice에 로드
		File file=new File("d:/salesReport.txt");
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
