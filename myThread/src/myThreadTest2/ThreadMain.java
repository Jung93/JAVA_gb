package myThreadTest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
	     //입력받을 정수를 int 타입 배열로 관리. 길이는 3
		int[] numbers = new int[3];
	
		   //쓰레드도 여러 개니 Thread 타입 배열 선언하고, int 배열의 길이만큼 길이 설정
	    Thread[] threads = new Thread[numbers.length];  
		
		//ThreadTask 객체화
	    ThreadTask threadTask = new ThreadTask();
	      //입력을 위해 Scanner 준비
	    Scanner sc = new Scanner(System.in);
	      //쓰레드 수(또는 입력 수)만큼 반복
	    for (int i = 0; i < threads.length; i++) {
	    	//같은 자원에 접근하기 위해 threadTask를 넘겨줌
			threads[i] = new Thread(threadTask);
		}
	      //입력  안내
	    System.out.println("입력 : ");
//	      쓰레드 수(또는 입력 수)만큼 반복
	    for (int i = 0; i < threads.length; i++) {
	    	//입력한 정수가 배열의 i 인덱스에 저장됨
			numbers[i] = sc.nextInt();
//	         입력한 순서대로 쓰레드의 이름으로 설정한다.
			//배열에 들어간 i 인덱스의 정수가 String.valueOf로 인해 String이 되고
			//그 String을 Thread 타입의 배열인 arThread의 i 인덱스의 setName에
			//전달되어 해당 객체의 이름이 된다.
			threads[i].setName(String.valueOf(numbers[i]));
		}
	    
//	      쓰레드 수(또는 입력 수)만큼 반복
	    for (int i = 0; i < threads.length; i++) {
	    	//각 쓰레드를 순서대로 start하는데
	    	//join을 걸어주어 순서를 부여한다.
			threads[i].start();
			try {	threads[i].join();} catch (InterruptedException e) {;}
		}
	   }
}
