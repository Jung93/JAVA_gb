package classTest;

class Test{
	int data;
	
	//; 일부러 비워놓은 거야 하는 약속
	public Test() {;}
	
	public Test(int data) {
		this.data = data;
	}
	
	void printData() {
		System.out.println(data);
	}
}



public class ClassArray {
	public static void main(String[] args) {
		Test[] arTest = new Test[12];
		
		for (int i = 0; i < arTest.length; i++) {
			arTest[i] = new Test(i+1);
		}
		arTest[10].printData();
		
//		for (int i = 0; i < arTest.length; i++) {
//			System.out.println(arTest[i]);
//		}
	}
}
