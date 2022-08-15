package myAmbiguityTest;

public interface InterB {
	//생략되는 abstract를 제거하기 위해
	default void printData() {
		System.out.println("InterB");
	}
}
