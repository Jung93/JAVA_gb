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
		
		
//		System.out.println(datas.get(0));
		//ArrayList에 추가하는 메소드 add()
		//추가하는 값은 <> 속의 타입.여기선 Integer
		//리턴은 true
		datas.add(10);
		System.out.println(datas);
		System.out.println(datas.get(0));
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
		
		//Collection과 Collections는 아예 다름
		//단수형은 인터페이스, 복수형은 클래스
		//sort() : ArrayList 내 값을 오름차순으로 정렬해주는 메소드
		Collections .sort(datas);
		System.out.println(datas);
		//내림차순 정렬하는 메소드는 없음.
		//sort()로 오름차순 정렬해주고 reverse()를 써서
		//반대로 정렬해서 내림차순처럼 만듬
		Collections.reverse(datas);
		System.out.println(datas);
		//무작위로 섞는 메소드
		Collections.shuffle(datas);
		System.out.println(datas);
	
//	추가(삽입)
//	50뒤에 500삽입
		System.out.println("삽입");
		//add(int index, element)로 삽입 시
		//값들이 해당 인덱스의 오른쪽으로 밀림
		//따라서 50 뒤에 추가하고 싶다면 50의 인덱스가 아니라
		//50의 인덱스+1에 추가해야함
		datas.add(datas.indexOf(50)+1,500);
		System.out.println(datas);
//	수정
//	90을 9로 수정
		System.out.println("수정");
		//set()의 리턴 값은 수정되기 이전의 값
		//여기선 90.
		//90을 9로 replace하고 90을 리턴
//		System.out.println(datas.set(datas.indexOf(90), 9)); = 90
		System.out.println(datas);
//	삭제
//	80삭제
//	1. 인덱스로 삭제
//		System.out.println("삭제 1");
		//해당 값의 인덱스를 찾아 그 인덱스에 존재하는 값을 삭제
		//indexOf는 좌에서 우로 검사하며 가장 처음 일치하는 값의 인덱스를 리턴
		//일치하는 값을 찾지 못했다면 -1 리턴
//		datas.remove(datas.indexOf(80));
//		System.out.println(datas);
//	2. 값으로 삭제
		System.out.println("삭제 2");
//		Integer data_I = datas.get(datas.indexOf(80));
//		datas.remove(data_I);
		
		//remove는 오버로딩되어 있어 매개변수로 int와 Object를 받을 수 있다.
		//따라서 그냥 int 를 넘겨주면 컴파일러가 우선적으로 return(int index)로
		//인식하기 때문에 값으로 삭제하는 게 아닌 index를 찾는다.
		//80을 넣으면 80번째 인덱스가 존재하지 않기 때문에 IndexOutOfBoundsException이 발생한다.
		//그렇기에 80을 Integer 타입으로 박싱하고
		//값을 넘겨주면 컴파일러가 자동으로 Object타입으로 업캐스팅하여
		//remove()에 전달하고 datas 안에 있는 80을 찾아서 삭제한다.
		datas.remove(Integer.valueOf(80));
		System.out.println(datas);
	}
}














