import java.util.ArrayList;
import java.util.Scanner;

public class arrayListPractice_2_07_29 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> point = new ArrayList<Integer>();
		int i = 0;
		int sum = 0;
		int param1 = sc.nextInt();
		while(param1 !=-1) {	
			point.add(param1);
			param1 = sc.nextInt();
		}
		for(int r=0;r<point.size();r++) {
			System.out.println(point.get(r));
			//합계 도 겸사겸사 이 for 문에서 처리
			sum = sum + point.get(r);
		}
			System.out.println("sum: "+sum);	
			System.out.println("average: "+sum/(point.size()));	
	}
}
