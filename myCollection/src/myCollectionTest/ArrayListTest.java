package myCollectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	
	
	public static void main(String[] args) {
		//<?> : 제네릭(이름이 없는) 
		//객체화 시 타입을 지정하는 기법
		//설계할 때에는 타입을 지정할 수 없기 때문에
		//임시로 타입을 선언할 때 사용한다.
		//따로 다운캐스팅을 할 필요가 없다.
		//지정할 타입에 제한을 줄 수 있다.
		
		ArrayList<Integer> datas = new ArrayList<>();
		
		
		System.out.println(datas.get(0));
		
		datas.add(10);
		datas.add(20);
		datas.add(40);
		datas.add(80);
		datas.add(60);
		datas.add(90);
		datas.add(50);
		datas.add(70);
		
//		System.out.println(datas.size());
		
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}
//		System.out.println(datas);
		
		Collections .sort(datas);
		System.out.println(datas);
		
		Collections.reverse(datas);
		System.out.println(datas);
		
		Collections.shuffle(datas);
		System.out.println(datas);
	
//	추가(삽입)
//	50뒤에 500삽입
		System.out.println("삽입");
		datas.add(datas.indexOf(50)+1,500);
		System.out.println(datas);
//	수정
//	90을 9로 수정
		System.out.println("수정");
		datas.set(datas.indexOf(90), 9);
		System.out.println(datas);
//	삭제
//	80삭제
//	1. 인덱스로 삭제
//		System.out.println("삭제 1");
//		datas.remove(datas.indexOf(80));
//		System.out.println(datas);
//	2. 값으로 삭제
		System.out.println("삭제 2");
//		Integer data_I = datas.get(datas.indexOf(80));
//		datas.remove(data_I);
		
		datas.remove(Integer.valueOf(80));
		System.out.println(datas);
	}
}














