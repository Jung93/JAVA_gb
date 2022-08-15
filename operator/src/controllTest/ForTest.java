package controllTest;

import java.util.Scanner;


public class ForTest {
	public static void main(String[] args) {
////		이름 10번 출력
//		for(int i=0; i<10; i=i+1) {
////		10~1까지 출력
//			System.out.println(10 - i + ".한동석");
////			System.out.println(i + 1 + ".한동석");
//		}
		
		
		
		String abc = "-1-1+3";
		String[] arAbc = abc.split("\\+|\\-");
		String[] arAbcP = abc.split("\\+");
		String[] arAbcM = abc.split("\\-");
		
		
		
		System.out.println(arAbc.length);
		System.out.println(arAbcP.length);
		System.out.println(arAbcM.length);
		
//		for (int i = 0; i < arAbc.length; i++) {
//			System.out.println(arAbc[i]);
//		}
//		System.out.println(arAbc[3]);
		
		
	};
	
}
