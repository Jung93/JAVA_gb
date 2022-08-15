package methodTest;

public class MethodTask {
	
//	1~10까지 println()으로 출력하는 메소드
	void printFrom1To10() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}
	
//	"홍길동"을 n번 println()으로 출력하는 메소드
	void printHong(int count){
		for (int i = 0; i < count; i++) {
			System.out.println("홍길동");
		}
	}
	
//	이름을 n번 println()으로 출력하는 메소드
	void printName(String name, int count){
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}
	
//	세 정수의 뺄셈을 해주는 메소드
	int substract(int firstNumber, int middleNumber, int lastNumber){
		return firstNumber - middleNumber - lastNumber;
	}
	
//	두 정수의 나눗셈을 해주는 메소드(몫과 나머지 둘 다)
	int[] divide(int num1, int num2){
		int[] results = null;
		
		if(num2 != 0) {
			results = new int[2];
			
			results[0] = num1 / num2; 
			results[1] = num1 % num2;
		}
		return results;
	}
	
//	1~n까지의 합을 구해주는 메소드
//	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//	문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//	문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//	5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	
//	한글을 정수로 바꿔주는 메소드 (일공이사 -> 1024), indexOf() 사용
//	"공일이삼사오육칠팔구"
//	"일공이사"
//	"공일이삼사오육칠팔구".indexOf("일") --> 1
//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	
//	어려움★★★★★
//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다)
//	매개변수는 2개 전달해야 한다.
//	예) getMaxAndMin();
//	   여기서부터 최대값, 최소값 사용 가능
	
	
	void test(int[] data) {
		data[0] = 10;
	}
	
	public static void main(String[] args) {
		MethodTask mt = new MethodTask();
		
		int[] data = {20};
		
		mt.test(data);
		System.out.println(data[0]);
		
//		mt.printFrom1To10();
//		mt.printHong(10);
//		mt.printName("한동석", 10);
//		System.out.println(mt.substract(5, 4, 2));
//		int[] results = mt.divide(10, 3);
//		String msg = null;
//		msg = results == null ? "0으로 나눌 수 없습니다." : "몫 : " + results[0] + "\n나머지 : " + results[1];
//		
//		System.out.println(msg);
		
		
//		getMaxAndMin(arData, results);
//		results[0], results[1]
		
	}
}








