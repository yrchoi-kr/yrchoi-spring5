
public class primeNumber0726 {

	public static void main(String[] args) {
		for(int n=2; n<=10000; n++) {
			for(int c=2;c<=n;c++) {
				if(n%c==0) {
					if(n==c)
					System.out.println(n+"는소수 임");
					break;
				}

					
			}
		}
	}
}
