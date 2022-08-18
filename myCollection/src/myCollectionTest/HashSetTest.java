package myCollectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		//HashSet은 중복검사
		HashSet<String> bloodTypes = new HashSet<>();
		//중복검사 끝난 HashSet 객체를 ArrayLsit에 넣어 index로 관리 가능
		ArrayList<String> bloodTypeList = null;
		
		bloodTypes.add("A");
		bloodTypes.add("B");
		bloodTypes.add("O");
		//Set은 중복되면 알아서 처리
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");

		//HashSet으로 중복검사하고 순서대로 관리하고 싶을 때 HashSet 객체를
		//ArrayLsit의 생성자에 넣을 수 있음
		bloodTypeList = new ArrayList<String>(bloodTypes);
		
		System.out.println(bloodTypeList.get(0));
//		System.out.println(bloodTypes);
//		
//		Iterator<String> bt = bloodTypes.iterator();
//		
//		while(bt.hasNext()) {
//			System.out.println(bt.next());
		}
}
