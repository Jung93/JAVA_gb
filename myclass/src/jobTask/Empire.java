package jobTask;

import java.util.Scanner;

public class Empire {
	public static void main(String[] args) {
		//선언부
		//Scanner 객체화
		Scanner sc = new Scanner(System.in);
		//Dictator 객체화
		Dictator d = new Dictator();
		String title = "♥독재시그널♥";
		String loginMsg = "아이디와 비밀번호를 입력해주세요.";
		String startGame = "계속하려면 ENTER를 누르세요";
		String startMsg = "환영합니다 독재자님! 당신을 보좌할 Be Trader입니다. \n"
				+ "시작에 앞서 성함을 알려주시기 바랍니다";
		String ruleMsg = "님이 시군요. 목표에 대해 간단하게 설명을 드리자면 당신의 해외계좌가 2억을 넘거나\n"
				+ "지지도가 100을 넘으면 승리하게 됩니다."
				+ "하지만 해외계좌 또는 지지도가 0 이하가 되면\n"
				+ "자리에서 쫓겨나게 되니 주의하셔야 합니다.\n"
				+ "그럼 시작해봅시다!";
		String actionMsg = "무엇을 하실 겁니까?\n1. 횡령하기\n2. 침략하기\n3. 내정보\n4. 나가기";
		String embezzleSuceessMsg = "님! 국민들이 눈치채지 못했습니다. " 
				+ "국고를 성공적으로 횡령하셨습니다!\n";
		String embezzleFailMsg = "이런...국민들이 알아챘습니다. " 
				+	"지지층 일부가 돌아섰습니다.\n";
		String invadeSuceessMsg = "님! 적국의 군대를 무찔렀습니다! "
				+	"상당량의 보물을 약탈해 개인금고에 보관했습니다.\n";
		String invadeFailMsg ="이런...적군이 너무 막강했습니다. " 
				+	"전쟁보상금을 마련하느라 재산과 지지도를 잃었습니다.\n";
		String exitMsg = "당신이 사라져 국민들이 민주주의로 돌아섰습니다.";
		String victoryAcountMsg= "충분한 돈이 모였습니다. 이제 해외로 도망갈 준비가 끝났습니다!";
		String victoryFollowerMsg= "국민들이 감복하여 당신을 종신 대통령으로 추대했습니다!";
		String defeatedAcountMsg= "님의 계좌가 텅 비었군요. 이제 제가 당신을 따를 이유가 없군요:>"
				+"\n나라는 제가 잘~통치할테니 편히 주무시기 바랍니다 하하하하하하하하!!";
		String defeatedFollowerMsg= "님...반란군이 황궁을 점령했습니다. 우리에게 남은 것은 처형 뿐이겠군요.";
		String errorMsg = "잘못 입력하셨습니다\n";
		String inputName = "이름 : ";
		String name = null, id= null, pw=null;
		int choice = 0;
		boolean check;
		
		//제목
		System.out.println(title);
		//enter 유도
		System.out.println(startGame);
		//엔터 입력용
		sc.nextLine();
		//이름 입력 유도
		System.out.println(startMsg);
		System.out.print(inputName);
		//이름 입력
		d.name = sc.next();
		//d는 객체. new Dictator(name)의 주소값을 가짐
		
		//승리, 패배 설명
		System.out.println(d.name +ruleMsg);
		
		//몇번 반복일지 모르니까 while
		while(true) {
			System.out.println(actionMsg);
			choice = sc.nextInt();
			//나가기 입력한 경우
			if(choice == 4) {
				System.out.println(exitMsg);
				break;
			}
			//choice가 4 아닌 경우
			switch(choice) {
			
			//1. 횡령하기
			case 1:
				//embezzle 메소드 실행해서 boolean 타입인 check에 담는다
				check = d.embezzle();
				System.out.print("열심히 횡령 중");
				//zoo에서 배웠던 컴파일러 멈추는 것. sleep() 안에는 ms단위
				for (int i = 0; i < 3; i++) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					// . 찍기
					System.out.print(". ");
				}
				System.out.println();
				//메소드 실행 결과 true면 if문 안으로 들어감
				if(check) {
					System.out.println(d.name+embezzleSuceessMsg);
					break;
				}
				//실패함ㅠ
					System.out.println(embezzleFailMsg);
					break;
			//2. 침략하기
			case 2:
				//case 1과 동일
				check = d.invade();
				System.out.print("평화로운 옆나라를 침공 중");
				for (int i = 0; i < 3; i++) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					System.out.print(". ");
				}
				System.out.println();
				if(check) {
					System.out.println(d.name+invadeSuceessMsg);
					break;
				}
					System.out.println(invadeFailMsg);
					break;
			//3. 내 정보
			case 3:
					System.out.println("내 이름 :" + d.name);
					//acount가 10_000 이상일 때 10_000으로 나눈 나머지가 
					//0이 아니라면 나머지+만원
					//0이라면 원
					String modulo = d.acount%10_000 !=0 ? d.acount%10_000 +"만원" : "원"; 
					//acount가 1억 이상일 때
					if(d.acount/10_000>0) {
						//예) acount가 15_500 -> 1억 5500만원
						System.out.println("해외계좌 : "+ d.acount/10_000+"억"+modulo);
					}else {
						//예) acount가 7_000 - > 7000만원
						System.out.println("해외계좌 : "+ modulo);
					}
					System.out.println("국민 지지도 : "+ d.follower+"%\n");
					break;
			//잘못 입력
			default:
				System.out.println(errorMsg);
				break;
			}
			//승리 조건. acount가 2억이상, follower가 100이상
			if(d.acount >=20_000 || d.follower >=100) {
					System.out.println(d.acount >=20_000 ? victoryAcountMsg : victoryFollowerMsg);
					break;
			}
			//패배 조건. acount가 0이하, follower가 0 이하
			if(!(d.acount > 0) || !(d.follower >0)) {
				
				if(d.acount <=0) {
					System.out.println(d.name+defeatedAcountMsg);
					System.out.println("해외계좌 : "+ d.acount+"원");
				}else if(d.follower <=0) {
					System.out.println(d.name+defeatedFollowerMsg);
					System.out.println("국민 지지도 : "+ d.follower+"%");
				}
					break;
			}//패배 if 닫는 중괄호
		}//while문 닫는 중괄호
	}//main 메소드 닫는 중괄호
}//Empire 클래스 닫는 중괄호
