package classTest;

class A{
	int data;
	
	A(int data){
		System.out.println(this);
		this.data = data;
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(10);
		System.out.println(a);
		
//		a.printData();
	}
}














