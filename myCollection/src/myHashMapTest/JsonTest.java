package myHashMapTest;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		//JSON부분 녹화본 복습하기
		
		HashMap<String, Object> userMap = new HashMap<String, Object>() ;
		JSONObject userJSON = null;
		JSONArray users = new JSONArray();
		
		userMap.put("id", "orijung93");
		userMap.put("pw", "1234");
		userMap.put("name", "정재훈");
		userMap.put("age", 30);
		
		userJSON = new JSONObject(userMap);
//		System.out.println(userJSON.toJSONString());
		
		users.add(userJSON);
		
		userMap.put("id", "persona");
		userMap.put("pw", "4321");
		userMap.put("name", "정영훈");
		userMap.put("age", 32);
		
		userJSON = new JSONObject(userMap);
		users.add(userJSON);
		System.out.println(users.toJSONString());
		
		System.out.println(((JSONObject)users.get(1)).toJSONString());
		
	}
}
