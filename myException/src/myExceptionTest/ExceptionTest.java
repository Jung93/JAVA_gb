package myExceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		
		try {
		System.out.println(10/0);
		}/*catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없읍니다");
		}*/
		catch(Exception e) {
			System.out.println("알 수 없는 오류");
			System.out.println(e);
		}
		
		System.out.println("반드시 실행되어야 하는 문장입니다");
		
	}
}
