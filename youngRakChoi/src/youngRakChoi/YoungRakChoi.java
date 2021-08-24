package youngRakChoi;

public class YoungRakChoi {
	public static void main(String[] args) {
		Student s1 = new Student();
		Computer com = new Computer();
		StarCraft star = new StarCraft();
		s1.name = "최영락";
		s1.nYear = 6;
		s1.nClass = 5;
		s1.birthday = "198907xx";
		s1.gender = "남";
		s1.mobile = "0107111xxxx";
		
		com.core = 8;
		com.grapicCard = "GForce 1080 Supper";
		com.memory = "1Tb";
		com.usbPort = 4;
		
		star.species = "Teran";
		star.mineral = 1240;
		star.gas = 542;
		star.people = 120;
		star.unit = "Marin";
		star.structure = "Command Center";
		System.out.println(s1.name);
		System.out.println(s1.nYear);
		System.out.println(s1.nClass );
		System.out.println(s1.birthday);
		System.out.println(s1.gender);
		System.out.println(s1.mobile);
		System.out.println();
		System.out.println(com.core);
		System.out.println(com.grapicCard);
		System.out.println(com.memory );
		System.out.println(com.usbPort);
		System.out.println();
		System.out.println(star.species);
		System.out.println(star.mineral);
		System.out.println(star.gas);
		System.out.println(star.people);
		System.out.println(star.unit);
		System.out.println(star.structure);
		
		
	}
}
