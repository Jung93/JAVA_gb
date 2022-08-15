package myLambdaTest;

public class PrintNameTest {
//외부에서 람다식으로 구현한 값을 name으로 전달받기
	
//	public static String printFullName(String firstName, String lastName) {
//		PrintName printName = (first, last)-> first+last;
//		String result = printName.mixName(firstName, lastName);
//		return result;
//	}
	
	
	public static void printFullName(PrintName name) {
//		name = (firstName, lastName) -> firstName+lastName;
		System.out.println(name.mixName("정", "재훈"));
	}
	
	public static void main(String[] args) {
		//매개변수 2개를 설정하고 , 두 문자열을 연결하도록 구현한다.
		
//		PrintName printName = (firstName, lastName)-> firstName+lastName;
//		String result = printName.mixName("정", "재훈");
//		
//		System.out.println(result);
		
		//static이라 바로 사용 가능.
		//람다식을 주소값으로 볼 줄 알아야한다.
		//변수로도 사용 가능하며, 매개변수로도 전달 가능하다.
		//전달된 람다식이 printFullName에 PrintName 타입으로 전달되며
		//PrintName의 메소드가 구현되어 메모리에 할당되고 주소값이 생김.
		//결국 그 주소값을 printFullName 메소드가 받아 .으로 접근하여 
		//구현된 mixName메소드에 매개변수를 전달.
		//"정"+"재훈" "정재훈"
		printFullName((a,b)->a+b);
		
//		System.out.println(printFullName("정", "재훈"));
		
	}
}
