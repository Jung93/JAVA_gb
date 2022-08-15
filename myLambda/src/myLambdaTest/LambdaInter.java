package myLambdaTest;

//함수형 인터페이스임을 알리는 장치. @는 어노테이션
//이걸 쓰면 추상 메소드를 딱 한개만 선언 가능
@FunctionalInterface
public interface LambdaInter {
	
	//타입 이름 (매개변수);
	//아직 구현되지 않은 메소드
	boolean checkMultipleOf10(int number);
}
