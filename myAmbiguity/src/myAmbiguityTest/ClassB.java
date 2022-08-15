package myAmbiguityTest;

//클래스와 인터페이스를 부모로 둔 경우
public class ClassB extends ClassA implements InterA{
	
	//자동으로 부모 클래스의 메소드가 사용됨.
	//인터페이스의 메소드를 사용하기 위해선
	//인터페이스명.super.메소드명();
	@Override
	public void printData() {
		super.printData();
	}
}
