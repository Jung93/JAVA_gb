package myExceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		
		try {
		System.out.println(10/0);
		}
		//모든 예외를 다 잡는 Excepton로 잡으면 다른 오류로 잡을 필요없음
		//대신 무슨 오류인지는 예외 객체를 통해 오류를 문자열로 출력하면 알 수 있다.
		/*catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없읍니다");
		}*/
		catch(Exception e) {
			System.out.println("알 수 없는 오류");
			System.out.println(e);
		}
		//try catch를 통해 오류가 발생해도 강제 종료를 방지할 수 있다.
		System.out.println("반드시 실행되어야 하는 문장입니다");
		
	}
}
