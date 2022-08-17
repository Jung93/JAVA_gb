package myCollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		//value  ->  아이디, 비번, 이름, 나이
		HashMap<String, Object> userMap = new HashMap<String, Object>() ;
		
		userMap.put("id", "orijung93");
		userMap.put("pw", "1234");
		userMap.put("name", "정재훈");
		userMap.put("age", 30);
		
		System.out.println(userMap.size());		
		System.out.println(userMap);		
		System.out.println(userMap.get("id"));
		
		Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
		
		while(iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Iterator<String> iter2 =  userMap.keySet().iterator();
		
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		for (Object value : userMap.values()) {
			System.out.println(value);
		}
	}
}
