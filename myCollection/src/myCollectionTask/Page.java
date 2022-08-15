package myCollectionTask;

import java.util.Random;
import java.util.Scanner;

public class Page {
	public static void main(String[] args) {
//		User user = new User();
//		User user2 = new User();
		
//		user.setName("Hi");
//		user.setId("WOW");
//		user.setPassword("qr!@saqqwQW");
//		user.setPhoneNumber("01019920331");
//		
//		user2.setName("Hepo");
//		user2.setId("AAA");
//		user2.setPassword("aE!@2rf442W");
//		user2.setPhoneNumber("010112225681");
//		
//		userField.userInfo.add(0, user);;
//		userField.userInfo.add(1, user2);;
//		System.out.println(userField.userInfo);
		
//		System.out.println(userField.userInfo.get(0).getId().equals("AAA"));
		
//		userField.signUp("정","AAA","qawsed","010101012");
//		userField.signUp("김","BBB","12w3d","0106122152");
//		userField.signUp("박","Ca2","!qgWw","01010628642");
		
		UserField userField = new UserField();
		Scanner sc = new Scanner(System.in);
		
		String msg = "1. 회원가입\n2. 로그인\n3. 비밀번호 변경\n4. 나가기";
		String privateMsg = "회원 가입을 위해 개인 정보를 입력해주세요.";
		String name = null, id = null, password = null, phoneNumber = null;
		String verifiedText = null;
		int choice = 0;
		User user = null;
		
		while(true) {
			System.out.println(msg);
			choice = sc.nextInt();
			if(choice == 4) {break;}
			
			switch(choice) {
			
			case 1:
				System.out.println(privateMsg);
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("아이디 : ");
				id = sc.next();
				System.out.print("비밀번호 : ");
				password = sc.next();
				System.out.print("핸드폰번호 : ");
				phoneNumber = sc.next();
			
				user = userField.signUp(name, id, password, phoneNumber);
				if(user != null) {
					System.out.println("회원 가입을 축하합니다");
					break;
				}
					System.out.println("이미 가입된 아이디입니다.");
					break;
			case 2:
				System.out.print("아이디 : ");
				id = sc.next();
				System.out.print("비밀번호 : ");
				password = sc.next();
					
				user = userField.login(id, password);
				if(user == null) {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
					break;
				}
					System.out.println("로그인 성공");
					break;
				
			case 3:
				System.out.print("아이디 : ");
				id = sc.next();
				
				if(userField.checkId(id) != null) {
					String verifyText = userField.sendSms();
					System.out.print("인증번호 입력 : ");
					verifiedText = sc.next();
					if(verifyText.equals(verifiedText)) {
						System.out.println("새 비밀번호를 입력해주세요.");
						password = sc.next();
						
						user = userField.checkId(id);
						user.setPassword(password);
						userField.changePassword(user);
						break;
					}
					System.out.println("인증번호가 틀렸습니다.");
					break;
				}
					System.out.println("존재하지 않는 아이디입니다.");
					break;
					}//switch
			}//while
	}//main
}//class
