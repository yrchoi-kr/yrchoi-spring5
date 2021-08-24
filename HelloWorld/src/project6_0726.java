import java.util.Scanner;

public class project6_0726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//요구 사항 입력 배열, 어느 숫자 까지 입력 할 지를 변수로 받음
		System.out.println("행열의 수 를 입력하세요");
		String param1 = sc.nextLine();
		
		//입력 변수 형변환
		int arrNum = Integer.parseInt(param1);
			
		//정수 입력 받아 정수 x 정수 행열 만듬
		int[][] arr = new int[arrNum][arrNum];
		
		//for문에 영향 받지 않도록 밖에서 num 선언
		int num = 1;
		
		//스테이크 형 배열에 입력받은 숫자 까지 입력
		for (int i = 0; i < arr.length; i++) {
			if(i%2==0) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = num;
					num++;
				}
			}
			else {
				for(int j = arrNum-1; j >=0 ; j--) {
					arr[i][j] = num;
					num++;
				}
			}
		}
		//스네이크형 배열 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}