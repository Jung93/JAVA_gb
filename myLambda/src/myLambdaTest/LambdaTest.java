package myLambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
		
		                                             //람다식(Lambda expression)
		LambdaInter lambdaInter1 = (number) -> number%10==0;
		//람다식은 익명 클래스랑 결과가 똑같음. 결국 주소값이라고 볼 수 있어여한다.
		//값이기 때문에 맞는 타입에 저장해야 한다.
		//익명 메소드라고 부르기도 한다.
		//위의 예시는 저 자체로 리턴값;
		//2개 이상의 문장을 작성해야 한다면 (매개변수)->{ 문장;return 리턴값;}
		
		//리턴값이 boolean타입이므로 boolean타입의 변수 result에 저장
		//객체에 .로 접근하여 메소드 사용
		boolean result = lambdaInter1.checkMultipleOf10(10);
		System.out.println(result);
	
		//문장이 2개 이상일 때의 람다식
		LambdaInter lambdaInter2 = (n) -> {
			System.out.println("10의 배수 검사");
			return n % 10 ==0;
		};
			boolean result2 = lambdaInter2.checkMultipleOf10(20);
			System.out.println(result2);
	}
}
