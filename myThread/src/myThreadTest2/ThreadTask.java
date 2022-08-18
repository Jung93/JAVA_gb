package myThreadTest2;

public class ThreadTask implements Runnable{
//  제한시간 : 1시간
  // 3개의 쓰레드가 있다.
  // Thread1, Thread2, Thread3
  // 사용자가 입력한 순서대로 각 알맞는 문자열이 출력된다.

  // 입력 예) 3 1 2
  // 출력 예) third first second

  // 단, Thread들은 항상 1, 2, 3 순서로 실행되어야 한다.

  // Thread1 : third
  // Thread2 : first
  // Thread3 : second

  // 출력 시 쓰레드의 번호도 출력할 경우 가산점으로 처리한다.
  
	//Thread의 이름과 입력된 숫자를 일치시키자.
	// 1 -> Thread1  2->Thread2 3->Thread3
	//그럼 숫자와 Thread의 이름을 비교해서 같은지 확인해야함
	//출력 순서에 따라 증가. 아래 메소드 보면 알겠지만
	//전위형으로 증가시켜 바로 출력될 수 있도록 만듬
  int count;
	
  public ThreadTask() {;}

  public void printFirst(Runnable first) {
	  //run()이 재정의된 Runnable 타입의 객체의 주소에 접근하여
	  //구현된 run()을 실행하는 메소드
     first.run(); // 수정 금지
  }

  public void printSecond(Runnable second) {
	//run()이 재정의된 Runnable 타입의 객체의 주소에 접근하여
	  //구현된 run()을 실행하는 메소드
     second.run(); // 수정 금지
  }

  public void printThird(Runnable third) {
	//run()이 재정의된 Runnable 타입의 객체의 주소에 접근하여
	  //구현된 run()을 실행하는 메소드
     third.run(); // 수정 금지
  }
  
  @Override
	public void run() {
	  switch(Thread.currentThread().getName()) {
//     외부에서 접근한 쓰레드의 이름이 곧, 사용자가 입력한 값이다.
	  //run을 재정의하는데 현재 접근한 쓰레드의 이름을 가져와서 switch문에 전달
	  //전달받은 쓰레드의 이름과 case를 비교
	  //사용자가 1을 입력했다면, 
	  //사용자가 2을 입력했다면,
	  //사용자가 3을 입력했다면,
	  case "1":
		  printFirst(()->System.out.println("Thread" + ++count + " : first"));
		  break;
	  case "2":
		  printSecond(()->System.out.println("Thread" + ++count + " : second"));
		  break;
	  case "3":
		  printThird(()->System.out.println("Thread" + ++count + " : third"));
		  break;
	  }
	}
}

