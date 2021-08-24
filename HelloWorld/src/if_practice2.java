import java.util.Scanner;

public class if_practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String param1 = sc.nextLine();
		//PTI = param Trance for Int
		int pti = Integer.parseInt(param1);
		
		if(pti>89) {
			System.out.println("A");
		} else if(pti>79){
			System.out.println("B");
		} else if(pti>69){
			System.out.println("C");
		} else if(pti>59){
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}

}
