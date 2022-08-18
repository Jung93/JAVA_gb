package myHashSetTest;

public class Student {
	private int number;
	private String name;
	
	public Student() {	;}

	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + ", " + number;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj == this) {
			return true;}
	
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(this.number == std.number) {
				return true;
			}
		}
		return false;
	}
	//equals 재정의할 때는 hashCode도 무조건 같이 재정의
	//equals에서 비교하려는 값을 리턴하도록.
	@Override
	public int hashCode() {

		return this.number;
	}
}
