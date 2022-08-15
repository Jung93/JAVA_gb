package apiTest;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsTest {
	public static void main(String[] args) {
		//coolSMS api
		//건당 20원.
		String api_key = "NCSBGR1K2TNLV4TT";
	    String api_secret = "#ENTER_YOUR_OWN#";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    //수신번호
	    params.put("to", "01000000000");
	    //발신번호
	    params.put("from", "01000000000");
	    params.put("type", "SMS");
	    //문자 내용
	    params.put("text", "문 앞에 택배 놓고 갑니다.");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
}
