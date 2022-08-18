package myThreadTest;

public class Thread2 implements Runnable{

	@Override
	//run() 안쪽을 자원이라고 함
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {	Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
}
