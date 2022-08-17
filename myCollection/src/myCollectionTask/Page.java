package myCollectionTask;

import java.util.InputMismatchException;
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
		
		//선언부
		UserField userField = new UserField();
		Scanner sc = new Scanner(System.in);
		
		String msg = "1. 회원가입\n2. 로그인\n3. 비밀번호 변경\n4. 나가기";
		String privateMsg = "회원 가입을 위해 개인 정보를 입력해주세요.";
		String loginMsg = "아이디와 비밀번호를 입력해주세요.";
		String changePwMsg = "아이디와 핸드폰 번호를 입력해주세요.";
		String name = null, id = null, password = null, phoneNumber = null;
		String verifiedText = null;
		int choice = 0;
		User user = null;
		
		while(true) {
			//정수 이외의 값 입력 방지
			try {
				System.out.println(msg);
				choice = sc.nextInt();
				if(choice == 4) {break;}
				
				switch(choice) {
				
				case 1://회원 가입
					System.out.println(privateMsg);
					System.out.print("이름 : ");
					name = sc.next();
					System.out.print("아이디 : ");
					id = sc.next();
					System.out.print("비밀번호 : ");
					password = sc.next();
					
					System.out.print("핸드폰번호 : ");
					phoneNumber = sc.next();
					//User 타입의 객체에 저장
					user = userField.signUp(name, id, password, phoneNumber);
					//signUp()이 성공 시User타입을 리턴하기 때문에
					//if문 안으로 들어감
					if(user != null) {
						System.out.println(user.getName()+"님. 회원 가입을 축하합니다");
						break;
					}
						System.out.println("이미 가입된 아이디입니다.");
						break;
				case 2://로그인
					System.out.println(loginMsg);
					System.out.print("아이디 : ");
					id = sc.next();
					System.out.print("비밀번호 : ");
					password = sc.next();
					//User 타입의 객체에 저장	
					user = userField.login(id, password);
					//login()가 아이디, 비번 중 하나가 틀리면 null을 리턴하기 떄문에
					//if문 안으로 들어감. 로그인 실패
					if(user == null) {
						System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
						break;
					}
					//성공했다면 login이 User타입의 객체를 리턴하기 때문에
					// . 연산자를 통해 필드에 접근 가능. private으로 캡슐화했기 때문에
					//메소드만으로 접근 가능.(getter, setter)
						System.out.println(user.getId()+"님. 반갑습니다.");
						break;
					
				case 3://비밀번호 변경
					System.out.println(changePwMsg);
					System.out.print("아이디 : ");
					id = sc.next();
					System.out.print("핸드폰 : ");
					phoneNumber = sc.next();
					//User 타입의 객체에 저장	
					user = userField.checkId(id);
					//아이디가 일치하면 if문으로 들어감
					if(user != null) {
						//아이디가 일치한 객체의 phoneNumber에 접근하여 입력된 번호와
						//일치하는 지 확인
						if(user.getPhoneNumber().equals(phoneNumber)) {
						//senSms()에 입력된 전화번호를 매개변수로 전달하며 실행하고 변수에 저장
						String verifyText = userField.sendSms(phoneNumber);
						System.out.print("인증번호 입력 : ");
						verifiedText = sc.next();
						//인증번호와 입력된 인증번호 비교하여 일치하면 if문으로 들어감
						if(verifyText.equals(verifiedText)) {
							System.out.println("새 비밀번호를 입력해주세요.");
							password = sc.next();
							//새 비밀번호 입력해서 객체에 저장
							user.setPassword(password);
							//변경 메소드 실행. 매개변수로 비밀번호 변경된 user 객체 전달
							userField.changePassword(user);
							break;
						}//인증번호 if
						System.out.println("인증번호가 틀렸습니다.");
						break;
						}//핸드폰번호 확인 if
						System.out.println("명의가 일치하지 않는 전화번호입니다.");
						break;
					}
						System.out.println("존재하지 않는 아이디입니다.");
						break;
						}//switch
				//sc.next류의 타입과 일치하지 않는 값이 입력되었을 시
				//나타나는 예외(Exception)
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
			
			}//while
	}//main
}//class
