
public class AutoMobile {

	public static void main(String[] args) {
		Car seltos = new Car();
		seltos.setColor("blue");
		System.out.println("색상:"+seltos.getColor());
		seltos.setGuest(3);
		System.out.println("승객수:" +seltos.getGuest());
		seltos.drive(50);
		System.out.println("현재속도:"+seltos.getSpeed());
		seltos.stop();
		System.out.println("정지후 속도:"+seltos.getSpeed());

	}

}
