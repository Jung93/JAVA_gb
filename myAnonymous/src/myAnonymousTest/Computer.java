package myAnonymousTest;

public class Computer {
	public static void main(String[] args) {
		
		//인터페이스 생성자를 호출함과 동시에 익명클래스가 열리며
		//구현되지 않은 필드를 구현하고 메모리에 할당
		//익명 클래스는 구현을 위해 인터페이스를 지정 받는 거라
		//자식이라고 볼 수 있다. 자식의 주소값을 부모에게 넘기는
		//업캐스팅이다.
		Game game = new Game() {
			//구현된 상태.
			//안에 코드는 뭐 알아서 뚜루루
			@Override
			public void paly() {
				
			}
			
			@Override
			public void exit() {
				
			}
		};
		
			
	}
}
