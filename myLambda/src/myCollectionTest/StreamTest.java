package myCollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamTest {
	public static void main(String[] args) {
		
		//forEach()
		//여러 값을 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
		//forEach 메소드에는 Consumer 인터페이스 타입의 값을 전달해야한다.
		//Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다
		//매개변수에는 컬렉션 객체 안에 들어있는 값들이 순서대로 담기고
		//화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		
//		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>();		
//		ArrayList<Integer> datas = new ArrayList<Integer>();
//		
//		chinaTown.put("자장면", 4500);
//		chinaTown.put("짬뽕", 5500);
//		chinaTown.put("탕수육", 14500);
//		
//		//람다식
//		chinaTown.values().stream().forEach(price-> System.out.println(price));
//		chinaTown.values().forEach(price-> System.out.println(price));
//											      //참조형 문법
//		chinaTown.values().forEach(System.out::println);
		
//		datas.add(10);
//		datas.add(20);
//		datas.add(30);
//		datas.add(40);
		
//		datas.forEach(price -> System.out.println(price));
		//전달받은 매개변수를 그대로 메소드에 사용할 경우에는 참조형 문법을 사용할 수있다.
		//소속::메소드명 --> 전달받은 값을 메소드의 매개변수로 바로 전달해준다.
//		datas.forEach(System.out::println);
		
		//IntStream.range(start, end) start ~ end-1
		//IntStream.rangeClosde(start, end) start ~ end
//		IntStream.range(1, 10).forEach(System.out::println);
//		//1~10까지 출력
//		IntStream.range(1, 11).forEach(System.out::println);
//		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		//chars() : 문자열을 IntStream으로 변경
//		String data = "ABC";
//		data.chars().forEach(number -> System.out.println((char)number));
		
		//map() : 기존 값을 원하는 값으로 변경
//		String data = "ABC";
//		data.chars().map(number -> number+3).forEach(v -> System.out.print((char)v));
		
		//filter() : 조건식을 작성하여 false일 경우 제외시킨다.
//		IntStream.rangeClosed(1, 10).filter(number -> number%2==0).forEach(System.out::println);

		//sorted() : 오름차순으로 정렬한다
		Integer[] arData = {10, 40, 20, 30};
//		//가변인자 녹화본. 어떤 값이 얼마나 들어올지 알 수 없기 때문에 매개변수 자리에 ...로 표현
		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(arData));
//		System.out.println(datas);
//		//오름차순
//		datas.stream().sorted().forEach(System.out::println);
//		//내림차순
//		datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		//collect() : 결과를 다양한 타입으로 리턴해준다
//		ArrayList<Integer> results = 
//		//collect에서 toList를 했기 때문에 results에 담기 위해선 다운캐스팅을 해야한다.
//				(ArrayList<Integer>)datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
//		System.out.println(results);
		
//		Collectors.joining("구분점");
//		문자열 타입의 값을 원하는 구분점을 연결하여 리턴한다
//		문자열 타입이 아닌 값은 joining을 사용할 수 없다.
//		String result = datas.stream().sorted().map(String::valueOf).collect(Collectors.joining(", "));
//		
//		System.out.println(result);
		
//		ArrayList<String> phones = new ArrayList<>();
//		phones.add("010");
//		phones.add("3894");
//		phones.add("3964");
//		ArrayList<Integer> phonesa = new ArrayList<>();
//		phonesa.add(0);
//		phonesa.add(3894);
//		phonesa.add(3964);
//		System.out.println(phonesa);
//		//ArrayList를 Integer로 할 경우 010이 8로 나옴
//		String result = phones.stream().collect(Collectors.joining("-"));
//		System.out.println(result);
		//8진법 때문인가. 08, 09 입력 안됨
//		int data_i = 07;
//		System.out.println(data_i);
		
	}
}
