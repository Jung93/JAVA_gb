package objectTest;

import java.util.Random;

class Employee{
	int number;
	String name;
	
	public Employee() {;}

	public Employee(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		//주소 비교
		//주소가 같다면 값도 당연히 같기 때문에
		//true가 리턴
		if(this == obj) {
			return true;
		}
		
		//타입 비교
		//전달받는 객체의 주소가 Employee 타입이기 때문에
		//Employee와 비교.
		if(obj instanceof Employee) {
			//Object에 up casting되었기 때문에 Employee에 새롭게 만든 number와 name은 Object에 없다.
			//그래서 다운캐스팅하여 number와 name을 복구한다
			Employee anotherEmployee = (Employee)obj;
			//객체의 number와 전달받은 주소의 number의 값이 같은지 비교
			if(this.number == anotherEmployee.number) {
				return true;
			}
		}
		return false;
	}
}

public class EqualsTest {
	public static void main(String[] args) {
		
		Employee han = new Employee(1, "한동석");
		System.out.println(han.equals(new Employee(1, "한동석")));
		
//		String data1 = "ABC";
//		String data2 = "ABC";
//		String data3 = new String("ABC");
//		String data4 = new String("ABC");
//		
//		System.out.println(data1 == data2);
//		System.out.println(data1.equals(data2));
//		
//		System.out.println(data3 == data4);
//		System.out.println(data3.equals(data4));
		
//		Random r1 = new Random();
//		Random r2 = new Random();
//		
//		System.out.println(r1 == r2);
//		System.out.println(r1.equals(r2));
//		
//		r1 = r2;
//		System.out.println(r1 == r2);
//		System.out.println(r1.equals(r2));
		
	}
}
