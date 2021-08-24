
public class Car {
	Tire frontLeft;
	Tire frontRight;
	Tire backLeft;
	Tire backRight;
	
	Car(){
		frontLeft=new Tire("외쪽앞바퀴",6);
		frontRight=new Tire("오른쪽앞바퀴",2);
		backLeft=new Tire("왼쪽뒤",3);
		backRight=new Tire("오른쪽뒤",4);
	}
	int run() {

		System.out.println("자동차가 달립니다.");
		if(frontLeft.roll()==false) {
			stop(); return 1;
		}
		if(frontRight.roll()==false) {
			stop(); return 2;
		}
		if(backLeft.roll()==false) {
			stop(); return 3;
		}
		if(backRight.roll()==false) {
			stop(); return 4;
		}
		return 0;
	}
	private void stop() {
		System.out.println("자동차가 멈춥니다.");
		
	}
}
