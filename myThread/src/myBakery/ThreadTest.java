package myBakery;

public class ThreadTest implements Runnable{

	
	@Override
	public void run() {
		while(true) {
			System.out.println("실행중...");
			//Thread 종료 3번째 방법
			//interrupt()가 실행되면
			//Thread.interrupted()가 자동으로 true로 바뀜
			if(Thread.interrupted()) {
				break;
			}
		}
	}
}
