
public class Tire {
	int maxRotation; // 수명 (몇번 구르면 수명이 끝난다)
	int accRotation; // 현재까지 회전한 횟수
	String location; // 바퀴 위치
	
	Tire(String loc, int maxRoc){
		this.location = loc;
		this.maxRotation = maxRoc;
	}
	boolean roll() {
		++this.accRotation;
		if(this.accRotation<this.maxRotation) {
			System.out.println(this.location+" Tire 수명:"+(maxRotation-accRotation));
			return true;
		}
		System.out.println(this.location+" Tire 펑크");
		return false;
	}
}
