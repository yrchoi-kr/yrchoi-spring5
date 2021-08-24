import java.util.ArrayList;
//order에서 실적까지 저장 하려니 Menu의 수정 내용이 연동되지 않는 문제 발생 Order클래스는 order만처리하고 실적관련은 SalesReport클래스에서 저장하고 다루기로 함
public class Order extends Menu{
	ArrayList<String> alMobile;
	ArrayList<String> alMenu;
	ArrayList<Integer> alCount;
	ArrayList<Integer> alTotal;
	ArrayList<Integer> alPriceO;
	Menu order;
	Order(){
		alMobile = new ArrayList<String>();
		alMenu = new ArrayList<String>();
		alCount = new ArrayList<Integer>();
		alTotal = new ArrayList<Integer>();
		alPriceO = new ArrayList<Integer>();
	}
	void getMobileNum(String num, int index) {
		for(int i=0;i<index;i++) {
			alMobile.add(num);
		}
	}
	int addOrder(String index, int cnt) {
		//주문메뉴명 추가
		String orderedMenu=getName(Integer.parseInt(index));
		alMenu.add(orderedMenu);
		//주문 수량 추가
		int cntP = cnt;
		alCount.add(cntP);
		//주문 가격 추가
		int price = getPrice(Integer.parseInt(index));
		alPriceO.add(price);
		int sum = (cntP*price);
		alTotal.add(sum);
		return sum;
	}
	int getTotalSum(int index) {
		//주문리스트의 총액을 모두 더해서 합계를 반환
		int sumAll = 0;
		for(int i=0;i<this.alMenu.size();i++) {
			sumAll += this.alTotal.get(i);
		}
		return sumAll;
	}
	void showOrderList() {
		//작업 확인용
		System.out.println("제품\t단위가격\t갯수\t가격총\t모바일번호");
		for(int i=0;i<this.alMenu.size();i++) {
			System.out.println((i+1)+ " " +this.alMenu.get(i)+"\t"+this.alPriceO.get(i)+"\t"+this.alCount.get(i)+"\t"+this.alTotal.get(i)+"\t"+this.alMobile.get(i));
		}
	}
	String getMenu(int index) {
		return this.alMenu.get(index);
	}
	int getalPriceO(int index) {
		return this.alPriceO.get(index);
	}
	int getalCount(int index) {
		return this.alCount.get(index);
	}
	int getalTotal(int index) {
		return this.alTotal.get(index);
	}
	int getalMenuSize() {
		return this.alMenu.size();
	}
	
}
