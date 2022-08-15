package method;

public class MethodTest {
	// 두 정수의 곱셈 메소드 선언
	
		int mutiple(int firstNumber, int lastNumber){
//				int result = firstNumber*lastNumber;
//				return result;
			return firstNumber * lastNumber;
		}
	
	//static
//컴파일러가 가정 먼저 메모리에 할당하게 하는 명령어
//일반 메소드를 static 메소드에서 사용하기 위해서는
//		1. static을 붙여서 같이 메모리에 올린다
//		2. 일반 메소드의 소속을 알려준다. 클래스명 변수 = new 클래스명();
//		- static 메소드에서 사용된 일반 메소드는 Heap영역에서 찾는다.
//		- 클래스 타입의 변수를 선언할 때(new) Heap 영역에 할당되므로
//		  일반 메소드도 해당 변수를 통해 접근하여 사용할 수 있다.
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		int result = 0;
		
		result = mt.mutiple(3, 7);
		System.out.println(result);
	}
}
