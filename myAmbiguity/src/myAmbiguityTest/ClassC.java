package myAmbiguityTest;

//인터페이스는 ,로 구분하여 여러개 동시에 지정 가능
//다만 모호성이 생김
public class ClassC implements InterA, InterB{
	
	//모호성을 해결하기 위해
	//자식 클래스에서 메소드를 재정의하여 사용.
	@Override
	public void printData() {
		InterA.super.printData();
	}	
}
