package objectTest;

import java.util.Random;

class Student {
	int number;
	String name;
	
	//기본 생성자
	public Student() {;}
	//초기화 생성자
	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	
	//toString을 재정의하여 사용
	@Override
	public String toString() {
		return number + ", " + name;
	}
}

public class ToStringTest {
	public static void main(String[] args) {
		Random r = new Random();
		//지금까지 객체를 출력할 때 컴파일러가 toString()을 자동으로 붙여줬었다
		System.out.println(r.toString());
		
		//toString을 재정의하였기 때문에 재정의한 대로 실행된다.
		Student std = new Student(1, "한동석");
		System.out.println(std);
	}
}





