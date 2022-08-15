package myInterfaceTest;

public class Cat implements Pet {
//인터페이스는 강제성이 있기 때문에
	// 지정된 클래스는 인터페이스의 모든 메소드를 재정의해야만 한다.
	
	@Override
	public void bang() {
		System.out.println("무시한다");
	}

	@Override
	public void giveYourHand() {
		System.out.println("냥냥펀치 날린다.");
	}

	@Override
	public void bite() {
		System.out.println("문다.");
	}

	@Override
	public void sitDown() {
		System.out.println("지나간다.");
	}

	@Override
	public void waitNow() {
		System.out.println("안 기다린다.");
	}

	@Override
	public void getNose() {
		System.out.println("나를 안본다.");
	}
}
