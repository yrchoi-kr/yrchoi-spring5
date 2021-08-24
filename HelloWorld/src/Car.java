import java.util.ArrayList;

public class Car {
	String nColor;
	int maxSpeed;
	int nSpeed;
	int guest;
	String modelName;
	int nWheel;
	ArrayList<Integer> dailyRun;
	void drive(int x) {
		this.nSpeed= x;
	}
	void stop() {
		this.nSpeed = 0;
	}
	int getSpeed() {
		return this.nSpeed;
	}
	void setGuest(int x) {
		this.guest = x;
	}
	int getGuest() {
		return this.guest;
	}
	void setColor(String colorPrm) {
		this.nColor = colorPrm;
	}
	String getColor() {
		return this.nColor;
	}
}
