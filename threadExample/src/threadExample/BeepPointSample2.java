package threadExample;

public class BeepPointSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Runnable beepTask = new BeepTask();
//		Thread t = new Thread(beepTask);
		Thread t = new Task();
		t.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}

}
