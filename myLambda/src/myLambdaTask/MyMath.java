package myLambdaTask;

import java.util.Scanner;

public class MyMath {

	//연산자를 받아와야 함
	//
	public static Calc calculate(String oper) {
		Calc c= null;
		
		switch(oper) {
		case "+"://전달받은 연산자가 +일 떄
			c = (n1, n2) -> n1+n2;
		break;
		case "-"://-일 때
			c= (n1, n2) -> n1-n2;
		break;
		}
		return c;
	}
	
	public static void main(String[] args) {

		
		OperCheck operCheck = (ex)->{
			//전체 수식에서 연산자만 골라서 문자열에 담고
			//문자열 배열로 리턴
			String[] arNumber = ex.split("");
			String oper = "";
			

//			for (int i = 0; i < ex.length(); i++) {
//				String temp ="";
//				char c = ex.charAt(i);
//				if(c=='-'||c=='+') {
//					temp+=c;
//				}
//			}
			
			
 			for (int i = 0; i < arNumber.length; i++) {
				if(arNumber[i].equals("+") || arNumber[i].equals("-")) {
					oper+=arNumber[i];
				}
			}
			return oper.split("");
		};
		
		//음수 먼저 입력되면 -앞에 빈 문자열이 있는 거로 인식해서 오류남
		//-1-1+3 -> ""-1-1+3
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] numbers = input.split("\\+|\\-");//숫자 담김
		int[] numberInts = new int[numbers.length];
		String[] arOper = operCheck.checkOper(input);
		
		//음수부터 입력되었단 얘기
		//-1-1+3
		//{"",1,1,3} ->{  , , } 
		//음수 해결방법
		//맨 아래 반복문에 nums[0] = nums[0].equals("") ? "0" : nums[0];
		
		//number1 = Integer.parseInt(nums[0] = nums[0].equals("") ? opers[0] + nums[1] : nums[0])
		//if(i==0 &&number1<0){continue;}
		
		for (int i = 0; i < numberInts.length; i++) {
				numberInts[i] = Integer.parseInt(numbers[i]);
			}

		//		String[] expression = input.split("");//전부 한개씩 잘라서 담김. 7,+,1,0,-,9,3 이런 식
		
		
		
		//1+5-2   -> 4가 나오도록.  oper.split("")에는 {"+","-"}
		//calculate(oper.split("")[0]);-> case "+": 로 감
		//1+1-2 input
		//numbers[0] = 1, [1]=1, [2] =2
		//oper.splut("")[0]=+, [1]=-
		//반복 횟수 : operCheck의 checkOper에 접근해서 input을 넣으면 split 되어서 +-만 담김. 그래서 .length =2.
		//
		
		int i = 0;
		for (i = 0; i < arOper.length; i++) {
//			System.out.println(calculate(operCheck.checkOper(input)[i]).calc(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i+1])));
		
			Calc d = calculate(arOper[i]);
			
				numberInts[i+1] = d.calc(numberInts[i], numberInts[i+1]);
			
		}
		System.out.println(numberInts[i]);
	}
}
