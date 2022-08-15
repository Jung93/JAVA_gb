package lambda;

import java.util.Scanner;

public class MyMath {
//	외부에서 연산자 한 개를 전달받는다.
	public static Calc calculator(String oper) {
		Calc c = null;
		
		switch(oper) {
		case "+" : // 전달받은 연산자가 +일 때
			c = (n1, n2) -> n1 + n2;
			break;
		case "-" :
			c = (n1, n2) -> n1 - n2;
			break;
		}
		//리턴될 때 어떤 형식으로든 필드가 구현됨
		return c;
	}
	public static void main(String[] args) {
//		전체 수식에서 +와 -만 분리하는 메소드로 구현
		OperCheck operCheck = (ex) -> {
			String temp = "";
					
			//전체 수식에서 연산자만 골라서 문자열에 담고
			for (int i = 0; i < ex.length(); i++) {
				char c = ex.charAt(i);
				//-이거나+일때만 연결
				if(c == '-' || c == '+') {
					temp += c;
				}
			}
			//문자열 배열로 리턴
			return temp.split("");
		};
		
		String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요.";
		String exampleMessage = "예)9+7-5";
		String expression = null;
		String[] opers = null;
		String[] nums = null;
		int number1 = 0, number2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		System.out.println(exampleMessage);
		//사용자에게 전체 수식을 입력받는다.
		expression = sc.next();
//		위에서 구현한 연산자 추출 메소드에 전체 수식을 전달한다.
		opers = operCheck.checkOper(expression);
		//+와-릴 기준점으로 삼아 문자열 자름
		//정수부분만 남는다
		nums = expression.split("\\+|\\-");
		
//		-1+9+5
		//음수 오류 방지.
		//-로 시작하면 컴파일러가 ""를 -앞에 자동으로 추가하기 때문에 parseInt를 하면
		//오류가 남. 그래서 nums 배열의 0번방이 ""일 경우 0으로 덮어씌우고 ""아닐 경우 그대로 두는 방법으로
		//오류 해결. 제일 간단한 방법
//		nums[0] = nums[0].equals("") ? "0" : nums[0];
		
		//음수 오류 방지 2번째.
		//nums[0]이 ""라면 opers[0]이 -이기 때문에, opers[0]+nums[1]을 하면
		//마치 기존에 있던 음수인 것처럼 만들 수 있다. 그걸 parseInt로 정수로 형변환하여
		//number1에 넣어 진행한다.
		number1 = Integer.parseInt(nums[0].equals("") ? opers[0] + nums[1] : nums[0]);
		
		for (int i = 0; i < opers.length; i++) {
			//음수 시작일 경우 한번 건너뛰고 다음 반복부터 시작
			if(i == 0 && number1 < 0) {continue;}
			number2 = Integer.parseInt(nums[i + 1]);
			//첫번째 연산결과를 number1에 저장해야
			//다음 반복 때 이전 결과와 number2를 새로 연산할 수 있다
			number1 = calculator(opers[i]).calc(number1, number2);
		}
		//모든 연산이 끝나면 number1에 저장되기 때문에
		//number1을 출력한다
		System.out.println(number1);
	}
}




















