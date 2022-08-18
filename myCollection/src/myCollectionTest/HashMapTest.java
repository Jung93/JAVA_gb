package myCollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		//value  ->  아이디, 비번, 이름, 나이
		HashMap<String, Object> userMap = new HashMap<String, Object>() ;
		
		//Map에서는 add()가 아닌 put(). key와 value를 전달.
		//key는 중복 안됨. 중복일 경우 나중에 넣은 value로 수정된다.
		//value는 중복 가능.
		//key, value 한 쌍을 entry라고 한다.
		userMap.put("id", "orijung93");
		userMap.put("pw", "1234");
		userMap.put("name", "정재훈");
		userMap.put("age", 30);
		
		System.out.println(userMap.size());		
		System.out.println(userMap);
		//get()에 key 넣어 해당 객체에서 key와 맞는 value를 가져올 수 있다.
		System.out.println(userMap.get("id"));
		
		//entrySet()은 Key와 value를 Set타입으로 리턴, iterator()를 통해
		//순서를 부여할 수 있다.
		Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
		//iter에 값이 있다면 hasNext()가 true, 없으면 false 리턴
		while(iter.hasNext()) {
//			iter의 객체가 Entry<String, Object> 타입이므로 같은 타입으로 저장
			Entry<String, Object> entry = iter.next();
			//해당 객체에서 key와 value 가져와서 출력
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		//String 타입인 key만 가져와서 iterator 타입으로 저장 
		Iterator<String> iter2 =  userMap.keySet().iterator();
		//마지막까지 반복
		while(iter2.hasNext()) {
			//key만 출력
			System.out.println(iter2.next());
		}
		
		//value만 출력
		for (Object value : userMap.values()) {
			System.out.println(value);
		}
	}
}
