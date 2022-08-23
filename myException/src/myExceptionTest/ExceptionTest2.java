package myExceptionTest;

public class ExceptionTest2 {
//혼자 연습한 파일
	public static void main(String[] args) {
		
		int[] datas = {1,2,3,34,5,5,6,7};
		
		System.out.println(datas[7]);
		
		try {	print();} catch (NullPointerException e) {
			System.out.println("하하하");
			System.out.println(e);}
		//main 메소드도 throws 가능.
		//근데 어디로 throws 하는 거지?
	}
	public static void print() throws NullPointerException{
		String[] datas = new String[10];
		
		System.out.println(datas[0].getBytes());
		
	}
	
	
}
