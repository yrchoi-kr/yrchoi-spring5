
public class fibonacci_0726 {
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int c = 0;
		System.out.println(c);
		while(c<10000) {
			c = a + b;
			if(c>10000) break;
			System.out.println(c);
			a = b;
			b = c;
		}
		
	}
}
