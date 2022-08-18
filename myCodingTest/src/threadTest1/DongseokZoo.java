package threadTest1;

public class DongseokZoo {
	public static void main(String[] args) {
//		동석이네 동물원에는 3마리의 동물이 있다.
//		각 동물은 울음 소리가 다르고 2마리의 동물은 동시에 운다.
//		나머지 1마리 동물은 2마리 동물이 모두 울고 나서 마지막에 운다.
//
//		package명은 threadTest1으로 만들고 클래스는 2개만 선언한다.
//		하나의 클래스에는 main 쓰레드가 있다.
//		Runnable 인터페이스로 멀티 쓰레드를 구현하고 반드시 join()을 사용한다.
//		※ 각 동물은 10번씩만 운다.
		
		//sound, animal, thread 배열 선언
		String[] sounds = {"음메","멍멍","야옹"};
		Thread[] threads = new Thread[sounds.length];
		AnimalCry[] animals = new AnimalCry[sounds.length];
		//아무 length 잡고 반복
		for (int i = 0; i < animals.length; i++) {
			//animals 배열에 AnimalCry 타입 객체 주소 저장
			animals[i] = new AnimalCry();
			//threads 배열에는 animals와 sounds의  인덱스에 해당하는 값을 전달
			//AnimalCry가 Runnable을 지정받기 때문에 animals[i]는 업캐스팅됨
			//sounds는 그냥 들어감
			threads[i] = new Thread(animals[i],sounds[i]);
		}
		
		for (int i = 0; i < animals.length; i++) {
			//멀티 쓰레드 시작
			threads[i].start();
			if(i != 0) {
				//i가 1일 때 안으로 들어옴
				//threads[1]이 start() 실행하고나서 join이 걸리기 때문에
				//thread[0]과 thread[1]만 돌아가고 thread[2]는 대기
			try {	threads[i].join();} catch (InterruptedException e) {;}
			}
		}
	}	
}
