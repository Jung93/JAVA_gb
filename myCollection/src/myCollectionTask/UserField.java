package myCollectionTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField extends User{
		
	public ArrayList<User> userInfo = new ArrayList<>(); 


		//User
		public User checkId(String id) {
			User user = null;
			
			for (int i = 0; i < userInfo.size(); i++) {
				
				if(userInfo.get(i).getId().equals(id)) {
					user = userInfo.get(i);
					return user;
				}
			}
				return user;
		};
		
		public User signUp(String name, String id, String pw, String phoneNumber) {
			User user = checkId(id);
				
			if(user == null) {
			User userNew = new User();
				userNew.setName(name);
				userNew.setId(id);
				userNew.setPassword(encrypt(pw));
				userNew.setPhoneNumber(phoneNumber);
				userInfo.add(userNew);
				return userNew;
			}	
				return null;
		};
		
		
		//User
		public User login(String id, String pw) {
			User user = checkId(id);
			if(user != null) {
				if(user.getPassword().equals(encrypt(pw))) {
					return user;
				}
			}
			return null;
		};
		
		
		public String encrypt(String password) {
			String encryptedPw = "";
			final int KEY = 3;
			
			for (int i = 0; i < password.length(); i++) {
				char c= password.charAt(i);
				encryptedPw += (char)(c * KEY -7);
			}
			
			return encryptedPw;
		};
		
		public boolean changePassword(User user) {
			User userCheck = checkId(user.getId());
			
			if(userCheck != null) {
				userCheck.setPassword(encrypt(user.getPassword()));
				userInfo.set(userInfo.indexOf(userCheck), userCheck);
				return true;
			}	
				return false;
			
			};
		
		public String sendSms() {
			
			Random r = new Random();
			String str = "";
			for (int i = 0; i < 6; i++) {
				str += r.nextInt(10);
			}
			
			String api_key = "NCSCUZAQHUESP6UT";
		    String api_secret = "TPRJWMB9E9YACNFUUKNYMUXDN1EW610N";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();
		    //수신번호
		    params.put("to", "01038943964");
		    //발신번호
		    params.put("from", "01038943964");
		    params.put("type", "SMS");
		    //문자 내용
		    params.put("text", "인증 번호는 ["+str+"]입니다");
		    params.put("app_version", "test app 1.2"); // application name and version

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
		    return str;
		};
		
		
		
}
