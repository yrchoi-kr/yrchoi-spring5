import java.util.ArrayList;
import java.util.Scanner;

public class arrayListPractice07_28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> studentName = new ArrayList<String>();
		studentName.add("john");
		studentName.add("jane");
		studentName.add("jacob");
		studentName.add("johanson");
		studentName.add("jason");
		studentName.add("james");
		studentName.set(3, "jefferson"); //수정(reaplce)
		studentName.remove(3);
		studentName.remove("Json");
		for(int i=0;i<studentName.size();i++) {
			System.out.println(studentName.get(i));
		}
		System.out.println("\n\n\n");
	}
}
