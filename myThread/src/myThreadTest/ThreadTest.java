package myThreadTest;

public class ThreadTest {
	public static void main(String[] args) {
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
		
		//start()로 운영체제에 멀티 쓰레드라는 것을 알려줘야 함
//		t1.start();
//		t2.start();
		
		//main 쓰레드에서 그냥 주욱 실행
//		t1.run();
//		t2.run();
		
		//람다식으로 runner 재정의 및 구현
		Runnable runner = ()->{
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		};
		
//		Thread2가 Runnable을 지정받고 있기 때문에 Runnable 타입도 가짐.
//		Runnable t1 = new Thread2();//업 캐스팅
//		Thread2 t2 = new Thread2();
//		
		
//		재정의한 run()을 전달하기 위해 매개변수로 runner 넘김
		//String 타입을 넘겨 thread 이름으로 설정 가능
		Thread thread1 = new Thread(runner,"!");
		Thread thread2 = new Thread(runner,"?");
		
		
		thread1.start();
		thread2.start();
		
		//join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//					이미 start()된 쓰레드는 영향을 받지 않는다
//					만약 나중에 실행하고자 하는 쓰레드가 있다면 join() 다음에 start()를 실행해야 한다.
		
		//thread1과 thread2 가 언제 끝날지 모르기 때문에 둘 다 잡아야 안정적이다.
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {;}
		
		System.out.println("main 쓰레드 종료");
		
	}
}
