package myCollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		
		//1~10 ArrayList에 담고 출력
		ArrayList<Integer> dataLists = new ArrayList<Integer>();
		//1~10까지 생성된 int 값을 filter에 람다식으로 전달
		//dataLists.add()의 리턴타입이 boolean이라 filter 사용
		IntStream.rangeClosed(1, 10).filter(number->dataLists.add(number)).forEach(System.out::println);
		
//--------------------------------------------------------------------------		
		//1~100까지 중 홀수만 ArrayList에 담고 출력
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
		//위와 비슷
		//filter로 홀수만 고르고 선별된 홀수를 datas에 저장하고 출력
		IntStream.rangeClosed(1, 100).filter(n->n%2==1).filter(n->datas.add(n)).forEach(System.out::println);
//---------------------------------------------------------------------------		
		//ABCDEF를 각 문자별로 출력
		
		String str = "ABCDEF";
		//chars()를 통해 str의 각 문자를 IntStream으로 변환
		//각 int 타입 값들을 char 타입으로 형변환하고 출력하니 아스키코드에 의해
		//대응하는 문자가 출력
		str.chars().forEach(v ->System.out.print((char)v));
		System.out.println("\n--------------------");
//---------------------------------------------------------------------------		
		//A~F까지 ArrayList에 담고 출력
		ArrayList<String> alphabets = new ArrayList<>();
		//chars()로 가져온 int를 forEach를 통해 alphabets에 저장
		//alphabets가 String 타입을 객체로 가지기 때문에 형변환
		str.chars().forEach(v-> alphabets.add(String.valueOf((char)v)));
		System.out.println(alphabets);

//---------------------------------------------------------------------------		
	
		//A~F까지 D 제외하고 ArrayList에 담고 출력
		String noD = "ABCDE";
		ArrayList<String> arExceptD = new ArrayList<>();
//		noD.chars().filter(v -> v != 68).forEach(v -> arExceptD.add(String.valueOf((char)v)));
		//filter로 D를 건너뛰면 F까지 6번 반복
		//map으로 삼항을 쓰면 5번 반복
		noD.chars().map(v -> v>66? v+1:v).forEach(v -> arExceptD.add(String.valueOf((char)v)));
		
		System.out.println(arExceptD);

		
//---------------------------------------------------------------------------		

		//5개의 문자열을 입력받고 모두 소문자로 변경 String.toLowerCase()
		Scanner sc = new Scanner(System.in);
		
		String[] input = new String[5];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.next();
		}
		
//		ArrayList<String> inputDatas = new ArrayList<String>(Arrays.asList(input));
//		System.out.println(inputDatas);
		HashSet<String> inputDatas = new HashSet<String>(Arrays.asList(input));
		
//		inputDatas.stream().forEach(data -> System.out.println(data.toLowerCase()));
		
		//전달된 String 타입인 v 를 소문자로 바꿔서 forEach로 넘김
		inputDatas.stream().map(v->v.toLowerCase()).forEach(System.out::println);
		
		
//---------------------------------------------------------------------------		

		//Apple, banana, Melon 중 첫번째가 대문자인 문자열 출력
		
		String[] fruits = {"Apple", "banana", "Melon"};
		//검색 목적이라 set을 써봤음
		HashSet<String> set = new HashSet<String>(Arrays.asList(fruits));
		//String 타입인 v의 첫번째 문자가 대문자인지 검사 후 true인 경우만 출력
		set.stream().filter(v -> v.charAt(0) >=65 && v.charAt(0)<=90).forEach(System.out::println);

//---------------------------------------------------------------------------		

		//한글을 정수로
		
			String inputString = sc.next();
			String hangle = "공일이삼사오육칠퐐구";
			//입력 값을 IntStream으로 바꾸고 map에 넘김
			//map에서 number를 char로 변환하고 변환된 값으로 hangle에서 일치하는 문자의 인덱스를 뽑아서 넘김
			//넘겨받은 인덱스를 print로 붙여서 출력하면 해당하는 정수가 출력
			inputString.chars().map(number -> hangle.indexOf((char)number)).forEach(System.out::print);
		
//---------------------------------------------------------------------------		

		//정수를 한글로
			String inputString2 = sc.next();
			
			//위와 동일. 대신 인덱스말고 number에서 48을 빼 동일한 형태의 정수를 얻어 charAt에서 사용 
			//근데 map이 끝나고 char 타입을 리턴하는 게 아니라 정수를 리턴. 자동 형변환인지ㅠ
			inputString2.chars().map(number -> hangle.charAt(number-48)).forEach(v->System.out.print((char)v));
			
	}
}
