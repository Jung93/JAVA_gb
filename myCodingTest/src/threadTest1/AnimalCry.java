package threadTest1;

public class AnimalCry implements Runnable{
		
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {	Thread.sleep(500);} catch (InterruptedException e) {;	}
		}
	}
}
