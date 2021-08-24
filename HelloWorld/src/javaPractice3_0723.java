
public class javaPractice3_0723 {
	public static void main(String[] args) {

		int n = 1;
		while(n<101) {
			//홀수출력
			//if(n%2==0) System.out.println(n);
			//짝수출력
			//if(n%2==2) System.out.println(n);
			//5의 배수
			if(n%5==0) System.out.println(n);
			n++;
		}
		System.out.println("반복문 끝");
	}
}
