package lamp;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 전원 끄기 예약이 가능한 책상 조명
 */
//run() 재정의를 위해 Runnable을 implement함
public class TimerDeskLamp extends DeskLamp implements Runnable{

    final static int DELAY_MILLISECOND = 5000;

    private Thread offDelayThread; // 전원 끄기 예약 쓰레드
    //이전 전원 끄기 예약 쓰레드
    private Thread previousThread;

    //전원 끄기 예약 메소드
    public void offDelay() {
    	//이전에 실행된, 즉 현재 진행 중인 Thread가 null이 아니라는 것은
    	//이미 실행되고 있다는 뜻이니 interrupt를 발생시켜
    	//쓰레드를 종료시킴
    	if(previousThread != null) {
    		previousThread.interrupt();
    	}
    	//새로운 끄기 예약 쓰레드
    	offDelayThread = new Thread();
    	offDelayThread.start();
    	//previousThread를 새로운 끄기 예약 쓰레드로 덮어씌움
    	previousThread = offDelayThread;
    }
    //run() 재정의
    @Override
    public void run() {
    	//예약 여부 확인
    	while(true) {
    		//제시된 5초를 그냥 사용
    		try {	Thread.sleep(DELAY_MILLISECOND);} 
    		catch (InterruptedException e) {
    			//끄기 예약 쓰레드가 실행되고 있는 와중
    			//예약이 다시 실행되는 경우
    			System.out.println("타이머 리셋");
    			//아래 코드 실행되지 않도록 탈출
    			break;
    		}
    		//예약이 성공적으로 진행되면 turnOff
    		//DeskLamp를 상속하고 있어 사용 가능
    		turnOff();
    		//쓰레드가 정상 종료되었다는 것은 실행 중인 쓰레드가 없다는 것이므로
    		//null로 초기화
    		previousThread = null;
    		break;
    	}
    }

    // TODO - TimerDeskLamp 클래스의 나머지 코드를 구현해 주세요.

//	public void offDelayReservation(boolean power) {
//    	if(power) {
//    		if(timer == 0) {
//    		for (int i = 0; i < DELAY_MILLISECOND/1000; i++) {
//				System.out.println(timer++ + 1 + "초");
//				try {
//					Thread.sleep(DELAY_MILLISECOND/5);
//				} catch (InterruptedException e) {break;}
//			}
//    			turnOff();
//    			System.out.println("전원이 꺼졌습니다.");
//    			timer = 0;
//    	   }else {
//    		   System.out.println("timer reset");
//    		   timer = 0;
//    	   }
//    		
//    	}
//    }
		
//	@Override
//	public boolean getPower() {
//		return super.getPower();
//	}
	
	public static void main(String[] args) {
		
//		TimerDeskLamp tdl = new TimerDeskLamp();
//		Scanner sc = new Scanner(System.in);
//		int choice = 0;
//		
//		while(true) {
//			System.out.println("1. 켜기\n2. 끄기\n3. 끄기 예약");
//			choice = sc.nextInt();
//			
//			switch(choice) {
//			
//			case 1:
//				tdl.turnOn();
//				break;
//			case 2:
//				tdl.turnOff();
//				break;
//			case 3:
//				tdl.offDelayReservation(tdl.getPower());
//				break;
//			}
//		}
	}
}
