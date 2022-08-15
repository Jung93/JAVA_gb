package myExceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
		//5개의 정수 입력 받기
		// 무한 입력 상태로 구현
		// q 입력 시 나가기
		// 5개의 정수는 배열에 담기
		// if문은 딱 한번만 사용하기
		
//		Scanner sc = new Scanner(System.in);
//		String inputMsg = "정수 5개 입력 : ";
//		String exitMsg = "나가기(q) 다시하기(Enter)";
//		String exit = null;
//		int[] numbers = new int[5];
//		int number = 0;
//		
//		System.out.println(inputMsg);
//		while(true) {
//			try {
////				int i = 0;
////				while(true) {
////				numbers[i] = sc.nextInt();
////				i++;
////				}
//				for (int i = 0; i >= 0; i++) {
//					numbers[i] = sc.nextInt();
//				}
//			}catch(ArrayIndexOutOfBoundsException e){
//				System.out.println("5개의 정수만 입력해주세요.");
//			}catch(InputMismatchException e){
//				System.out.println("정수만 입력해주세요.");
//			}catch(Exception e) {
//				System.out.println("알 수 없는 오류가 발생했습니다.");
//			}
//				System.out.println(exitMsg);
//				exit = sc.next();
//				System.out.println(exit);
//				if(exit.equals("q")) {break;}
//		}
//			
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
			
			 Scanner sc = new Scanner(System.in);
		      int[] arData = new int[5];
		      String msg = "번째 정수 : ", temp = null;
		      int i = 0;
		      
		      while(true) {
		    	  //반복마다 i증가
		         System.out.print(++i + msg);
		         temp = sc.next();
		         if(temp.equals("q")) { break; }
		         
		         //오류 발생 가능성이 있는 문장을 try로 감싼다.
		         try {
		        	 //i가 1증가한 상태로 들어오므로 -1해서 인덱스번호를 맞춰준다
		            arData[i-1] = Integer.parseInt(temp);
		         } catch (NumberFormatException e) {//정수 이외의 값이 입력되었을 때
		            System.out.println("입력하기 전에 생각이란 걸 해봤나요? 제대로 입력하세요.");
		            //무의미한 i증가를 막기 위해 --;
		            i--;
		            
		         } catch (ArrayIndexOutOfBoundsException e) {//배열의 길이를 초과했을 때
		            System.out.println("5개만 입력가능합니다.");
		            for (int j = 0; j < arData.length; j++) {
		               System.out.print(arData[j] + " ");
		            }
		            break;
		            
		         } catch (Exception e) {//그외에 파악하지 못한 모든 오류는 이쪽으로
		            System.out.println("?");
		            //무의미한 i증가를 막기 위해 --;
		            i--;
		         }
		}
	}
}
