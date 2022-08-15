package myAmbiguityTest;

public interface InterA {
	//다중상속에 대한 사용자 민원? 때문에 JDK 8부터 생긴 문법
	//원래 추상메소드만 선언 가능한 인터페이스에서
	//딱 1개. default 메소드를 선언하는 것이 가능.
	//생략되는 abstract를 제거하기 위해
	//default 사용
	//default를 사용하지 않을 경우 메소드를 구현한 것처럼 되기 때문에 오류
	default void printData() {
		System.out.println("InterA");
	}
}
