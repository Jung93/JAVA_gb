package method;

import java.util.Scanner;

public class MethodTask {
	// 1~10까지 println()으로 출력하는 메소드
	
		void printNumber(){	
			for (int i = 0; i < 10; i++) {
				
				System.out.println(i+1);
			}
		}
	
	// "홍길동"을 n번 println()으로 출력하는 메소드
	
		void printHongGilDong(int number){
			for (int i = 0; i < number; i++) {
				String name = "홍길동";
				
				System.out.println(name);
			}
		}
	
	// 이름을 n번 println()으로 출력하는 메소드
	
		void printName(String name, int repeatNumber){
			for (int i = 0; i < repeatNumber; i++) {
				
				System.out.println(name);
			}
		}
	
	// 세 정수의 뺄셈을 해주는 메소드
	
		int minus(int firstNum, int secondNum, int lastNum){
			int result = firstNum-secondNum-lastNum;
			
			return result;
		}
		
	
	// 두 정수의 나눗셈을 해주는 메소드(몫,나머지 둘 다)
	
		int[] divide(int firstNum, int lastNum){
			int[] arDivision = null;
			
			if(lastNum !=0) {
			arDivision = new int[2];

			arDivision[0] = firstNum/lastNum;
			arDivision[1] = firstNum%lastNum;
			}
			return arDivision;
				
		}	
	//심화예제
	//   1~n까지의 합을 구해주는 메소드
		
			int getTotal(int number){
				int sum = 0;
				for (int i = 0; i < number; i++) {
					sum+=i+1;
				}
				return sum;
				
			}
		
	//   홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
		
			int changeNumber(int number){
			int result = 0;	
			result = number%2 == 0 ? number-1 : number+1;
				
			return result;
			}
		
	//   문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	
			String changeCapital(String input){
				char c= ' ';
				String result = "";
				
				for (int i = 0; i < input.length(); i++) {
					c= input.charAt(i);
					if(c>=65 && c<=90) {
						result+= (char)(c+32);
					}else if(c>=97 && c<=122){
						result+= (char)(c-32);
					}else {
						result+=c;
					}
				}
				return result;
			}
			
			
		//   문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
			
			
			int countChar(String input, char c){
				int length = input.length(), result = 0;
				char[] arChar = new char[length];
				
				for (int i = 0; i < length; i++) {
					arChar[i]=input.charAt(i);
				}
				
				for (int i = 0; i < length; i++) {
				result = arChar[i]==c ? ++result : result;
				}
			
				return result;
			}
	
		
		//   5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	
			int pickNumber(int[] arData, int wantNumber){
				int result = 0, index = wantNumber-1;
				
					result = arData[index];	
				
				return result;
				}
					
			
			
		//   한글을 정수로 바꿔주는 메소드
	
			String changeHangleToInt(String input){
				String hangle = "공일이삼사오육칠퐐구",result = "";
				
				for (int i = 0; i < input.length(); i++) {
					result += hangle.indexOf(input.charAt(i))+"";
				}
				//parseInt()로 리턴하면 리턴타입도 int 
				return result;
			}
			
		
		//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
		
			int[] calculateMaxAndMin(int[] arData){
				int max = 0, min = 0;
				int[] results = new int[2];
				
				max = arData[0];
				min = arData[0];
				for (int i = 0; i < arData.length; i++) {
					max = max < arData[i] ? arData[i] : max;
					min = min > arData[i] ? arData[i] : min;
				}
				results[0] = max;
				results[1] = min;
				
				return results;
			}
			
			//어려움★★★
			void checkMaxAndMin(int[] arData, int[] arResult){
				//최대 max, 최소 min 변수 선언하고 초기화
				int max = 0, min = 0;
				//max, min에 arData의 0번 째 값 대입	
				max = arData[0];
				min = arData[0];
				//arData의 길이만큼 반복.
				for (int i = 0; i < arData.length; i++) {
					//max와 다음번 방 값을 비교해서
					max = max < arData[i] ? arData[i] : max;
					//max와 동일하지만 작은 값을 대입
					min = min > arData[i] ? arData[i] : min;
				}
				//배열을 넘겨받을 때 값 자체가 아닌 주소값을 넘겨받는다
				//그래서 메소드 내부에서 넘겨받은 주소값에 접근하여 
				//해당하는 인덱스에 존재하는 값을 변경한다. 
				arResult[0] = max;
				arResult[1] = min;
			}
			
	public static void main(String[] args) {
		MethodTask mt = new MethodTask();
		
		//mt.printNumber();
		//mt.printHongGilDong(5);
		//mt.printName("정재훈", 7);
		//System.out.println(mt.minus(2, 3, -1));
		//System.out.println(mt.divide(0, 0)[0]);
	
		
		//심화예제 출력
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5], result = new int[2];
		int inputNum = 0;
		String inputString = null;
		
//		inputNum = sc.nextInt();
//		System.out.println(mt.getTotal(inputNum));
//		System.out.println(mt.changeNumber(inputNum));
		
		
//		inputString = sc.nextLine(); 
//		System.out.print(mt.changeCapital(inputString);
		
//		inputString = sc.nextLine();
//		System.out.println(mt.countChar(input, 'e'));
		
		//arData 길이만큼 정수 입력받아 arData에 대입
		for (int i = 0; i < arData.length; i++) {
			inputNum = sc.nextInt();
			arData[i] = inputNum;
		}
		
//		inputNum = sc.nextInt();
//		System.out.println(mt.pickNumber(arData, inputNum));
	
//		inputString = sc.nextLine();		
//		System.out.println(mt.changeHangleToInt(sc.next()));
	
//		System.out.println(mt.calculateMaxAndMin(arData)[0]);
	
		//메소드 사용
		//arData는 입력받은 5개의 정수가 담긴 정수배열의 주소값
		//result는 2칸으로 선언하여 초기값으로 0과 0을 가진 배열의 주소값
		//을 매개변수로 넘겨준다
		mt.checkMaxAndMin(arData, result);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
}
