package myCollectionTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField extends User{
	//collection framework 중에서 ArrayList
	//<E>는 제네릭. E 대신 원하는 타입으로 선언 가능
	//생성자 부분의 <>는 생략 가능
	public ArrayList<User> userInfo = new ArrayList<>(); 

		//User
		public User checkId(String id) {
			User user = null;
			
			//ArrayList의 길이를 가져올 때
			//배열, String과는 달리 length를 쓰지 않고 size()를 사용
			for (int i = 0; i < userInfo.size(); i++) {
				//userInfo 안에는 User 타입의 객체가 있다.
				//get(i)로 i번 째 객체를 가져와서 그 객체의
				//getter로 Id를 가져오고 매개변수로 입력된 Id와
				//같은지 값을 비교
				if(userInfo.get(i).getId().equals(id)) {
					//아이디가 같다면 그 아이디를 갖고 있는 객체를
					//user에 저장하고 리턴
					user = userInfo.get(i);
					break;
//					return user;
				}
			}
			//입력된 id가 없다면(if문에 들어가지 않다면) null이 리턴됨
				return user;
		};
		//매개변수로 줄줄이 쓰느니 User 타입으로 받는게 옳다
		public User signUp(String name, String id, String pw, String phoneNumber/*User user*/) {
			//아이디 중복 검사 시행
			User user = checkId(id);
			//아이디가 중복되지 않은 경우 checkId()가 null이기 떄문에
			//if문으로 들어감
			if(user == null) {
				//ArrayList 안으로 들어갈 새로운 User 타입의 객체
			User userNew = new User();
				userNew.setName(name);
				userNew.setId(id);
				//입력된 비번은 암호화해서 저장
				userNew.setPassword(encrypt(pw));
				userNew.setPhoneNumber(phoneNumber);
				userInfo.add(userNew);
				return userNew;
			}	
			//아이디가 중복되어 가입 실패
				return null;
//			//메소드에서 아이디 검사하면 정보 다 입력하고 실패 뜨니까 사용자가 불편
//			//따라서 아이디 검사는 화면 쪽에서 처리
//			user.setPassword(encrypt(user.getPassword()));
//			userInfo.add(user);
		};
		
		//User
		public User login(String id, String pw) {
			//아이디가 존재하는지 확인
			User user = checkId(id);
			if(user != null) {
				//아이디 검사 후 비밀번호 맞는지 확인
				//암호화해서 저장되어 있기 때문에
				//입력된 비번도 암호화해서 검사
				if(user.getPassword().equals(encrypt(pw))) {
					//아이디 비번 둘다 맞다면 해당 객체 리턴
					return user;
				}
			}
			//둘 중 하나가 틀려서 로그인 실패
			//user를 리턴하지 않는 이유는 아이디가 맞으면 전체 정보가 다 들어가기 때문
			return null;
		};
		
		//암호화
		public String encrypt(String password) {
			String encryptedPw = "";
			final int KEY = 3;//전역으로 선언하는 게 낫다
			
			for (int i = 0; i < password.length(); i++) {
				char c= password.charAt(i);
				encryptedPw += (char)(c * KEY -7);
			}
			
			return encryptedPw;
		};
		
		//비밀번호 찾기(새 비밀번호 입력)
		public void changePassword(User user) {
//			//전달받은 user 객체의 id를 가지고 확인
//			User userCheck = checkId(user.getId());
//			
//			if(userCheck != null) {
//				//아이디가 일치한 객체의 비밀번호를
//				//입력된 객체의 비밀번호를 가져와서 암호화하고 저장
//				userCheck.setPassword(encrypt(user.getPassword()));
//				//ArrayList 타입의 userInfo에서 set(인덱스, 객체)로 수정
//				//userCheck와 동일한 객체의 index 를 가져와서 해당 index에
//				//객체를 덮어씌움...?
//				userInfo.set(userInfo.indexOf(userCheck), userCheck);
//				return true;
//			}	
//				return false;
			//이건 DB 조회용
				User userOriginal = checkId(user.getId());
//				if(userOriginal != null) {
					userOriginal.setPassword(user.getPassword());
			};
		
			//외부 API를 활용한 인증 문자 보내는 메소드
			//매개변수로 전화번호 넘겨받음
		public String sendSms(String phoneNumber) {
			
			//0~9까지 랜덤한 숫자 6개를 조합해서 인증번호 생성
			Random r = new Random();
			String str = "";
			for (int i = 0; i < 6; i++) {
				str += r.nextInt(10);
			}
			//노출 주의!
			String api_key = "NCSCUZAQHUESP6UT";
		    String api_secret = "TPRJWMB9E9YACNFUUKNYMUXDN1EW610N";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();
		    //수신번호
		    //""도 문자열이니 전달받은 String을 넣어도 될 듯.
		    // 확인 결과 정상 작동
		    params.put("to", phoneNumber);
		    //발신번호
		    params.put("from", "01038943964");
		    params.put("type", "SMS");
		    //문자 내용
		    //랜덤 생성된 String 타입의 6자리 정수
		    params.put("text", "인증 번호는 ["+str+"]입니다");
		    params.put("app_version", "test app 1.2"); // application name and version

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
		    //인증번호와 화면에서 입력받은 번호를 비교하기 위해
		    //생성된 인증번호를 리턴
		    return str;
		};
		
		
		
		
		
		
		
}
