package myInterfaceTest;

public interface Pet {
	final static int eyes = 2;
	//final static 생략 가능
	//interface에는 상수와 추상메소드만 선언 가능하기 때문.
	//final은 어차피 상수만 쓰니 생략
	//static은 인터페이스를 생성자로 메모리에 올릴 수 없기 때문에
	//static을 써서 메모리에 올려야 함. 항상 필요한 거라 생략 가능.
	int nose = 1;
	
	//abstract 생략 가능
	public abstract void bang();
	public void giveYourHand();
	public void bite();
	public void sitDown();
	public void waitNow();
	public void getNose();
}
