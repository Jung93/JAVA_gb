package stringTest;

import java.util.Scanner;

public class StringTask {
	public static void main(String[] args) {
		//사용자에게 입력받은 문자열 중 소문자는 대문자, 대문자는 소문자로 변경
		Scanner sc = new Scanner(System.in);
		
//		String input = sc.next();
//		char cha = ' ', result = ' ';
//		
//		for (int i = 0; i < input.length(); i++) {
//			cha = input.charAt(i);
//			if(cha >= 'A' && cha <= 'Z') {
//				result = (char)(cha + 32);
//				System.out.print(result);
//				
//			}else if(cha >= 'a' && cha <= 'z') {
//				result = (char)(cha - 32);
//				System.out.print(result);
//				
//			}else {
//				System.out.print(cha);
//			}
//		}
	
		//정수를 한글로 변경
		//예) 1024 -> 일공이사
//		String hangul = "공일이삼사오육칠팔구";
//		String inputString = sc.next();
//		String result = "";
//		int inputNum = 0;
//		
//		inputNum = Integer.parseInt(inputString);
//		for (int i = 0; i < inputString.length(); i++) {
//			result +=hangul.charAt(inputNum%10);
//			inputNum /= 10;
//		}
//		for (int i = result.length()-1; i >=0 ; i--) {
//			System.out.print(result.charAt(i));
//		}

	}
}
