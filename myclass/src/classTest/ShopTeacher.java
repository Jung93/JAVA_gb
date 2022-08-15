package classTest;

import java.util.Scanner;

class SuperCarTeacher {
//   브랜드, 색상, 가격, 비밀번호, 시동 여부 확인하기 위한 check
	//(인스턴스 변수)
   String brand;
   String color;
   int price;
   String password;
   //외부에서 전달받는 값이 아닌, 내부적으로 사용되는 변수
   boolean check;

   //기본 생성자
   public SuperCarTeacher() {
      password = "0000";
   }
   
   //매개변수로 password를 넘겨받는 생성자 오버로딩
   public SuperCarTeacher(String password) {
      this.password = password;
   }
   //매개변수로 브랜드, 컬러, 가격, 비밀번호 넘겨받는 생성자 오버로딩
    public SuperCarTeacher(String brand, String color, int price, String password) {
      this.brand = brand;
      this.color = color;
      this.price = price;
      this.password = password;
   }
   
//   시동 켜기
//   시동의 상태를 확인하고 
//   시동이 꺼져있다면, "시동 켜기" 출력
//   이미 시동이 켜져있다면, "시동이 이미 켜져있습니다" 출력
   boolean engineStart() {
      //check의 기본값이 false기 때문에 ! 하면 true가 되어 if문 안으로
	  //들어감
	   if(!check) {
      //시동이 켜졌으니 check를 true로 바꿈
		 check = true;
         //(시동 켜기 성공(true 리턴))
		 return true;
      }
	   //if문에 안 들어갔다는 건 check가 true라는 얘기므로
	   //이미 켜져있다고 하기 위해false를 리턴
	   //(시동 켜기 실패)
      return false;
   }
   
//   시동 끄기
//   시동의 상태를 확인하고 
//   시동이 켜져있다면, "시동 끄기" 출력
//   이미 시동이 꺼져있다면, "시동이 이미 꺼져있습니다" 출력
   boolean engineStop() {
      //시동이 켜져있다면 check가 true일테니 if문 안으로 들어감
	   if(check) {
		 //시동이 꺼졌으니 check를 false로.
         check = false;
         //(시동 끄기 성공(true 리턴))
         return true;
      }
	   //이미 꺼져있다고 하기 위해 false 리턴
	   //(시동 끄기 실패)
      return false;
   }
   
//   [심화]
//   시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
//   입력한 비밀번호가 3회 연속 실패하면 "경찰 출동" 메세지를 출력한다.
   //비밀번호 확인하는 메소드
   //(외부에서 사용자가 입력한 비밀번호를 매개변수로 전달받는다)
   boolean checkPassword(String password) {
      //입력받은 비밀번호와 초기 비밀번호 같은지 확인. 문자열 비교는 equals.()
	   //this.password는 자동차 비번
	   //pasword는 입력받은 비번
	   //두 개를 비교해서 일치하면 true, 불일치면 false;
	   return this.password.equals(password);
   }
   
}

public class ShopTeacher {
	 public static void main(String[] args) {
		 //객체화, instance
		 SuperCarTeacher ferrari = new SuperCarTeacher();
	      
	      String msg = "1.시동켜기\n2.시동끄기", pwMsg = "비밀번호 : ", pw = null;
	      Scanner sc = new Scanner(System.in);
	      //choice는 사용자가 입력한 메뉴 번호
	      //count는 비번 오류 횟수
	      int choice = 0, count = 0;
	      // FLAG 깃발을 꽂는다. 해당 영역에서 연산된 결과를 다른 영역에서 사용
	      //하고자 할 때 표시하는 용도
	      boolean stopedEngine = false;
	      
	      do {
	         System.out.println(msg);
	         choice = sc.nextInt();
	         
	         switch(choice) {
	         case 1: // 시동 켜기
	            //ferrari 객체 안의 check를 체크
	        	//기본값이 false이기 때문에 if문으로.(시동이 꺼졌을 때)
	        	 if(!ferrari.check) {
	               System.out.print(pwMsg);
	               pw = sc.next();
	               //비번 확인 메소드의 리턴값이 boolean
	               //비번이 일치하면 true
	               if(ferrari.checkPassword(pw)) {
	                  ferrari.engineStart();//시동 켜기 메소드
	                  //비번 오류 초기화
	                  count = 0;
	                  System.out.println("시동 켜짐");
	               }else {
	            	  //비번 오류 회수 증가
	                  count++;
	                  System.out.println("비밀번호 오류 " + count + "회");
	                  if(count == 3) { //연속 3회 오류 시 들어옴
	                     System.out.println("경찰 출동");
	                  }
	               }
	               //{}가 너무 많아서 그냥 break 써서 즉시 탈출
	               break;
	            }
	            //check가 true라면 if문 실행 안하기 때문에 아래 코드 실행
	            System.out.println("이미 시동이 켜져있습니다.");
	            //이 break는 switch의 문법
	            break;
	         case 2:
	        	 //stopedEngine에 ferrari.engineStop() 대입
	        	 //시동 끄기를 시도한 결과를 stodEngine Flag에 담아준다.
	            if(stopedEngine = ferrari.engineStop()) {
	               System.out.println("시동 꺼짐");
	               break;
	            }
	            
	            System.out.println("이미 시동이 꺼져있습니다.");
	            break;
	         }
	         //count가 3이거나 stopedEngine이 true가 되면 반복 종료
	         //stopedEngine은 시동이 켜진 후 시동 끄기에 성공하면 true이다.
	         //true를 !으로 false로 바꾸기 때문에 탈출조건 1번 완성
	         //count는 오류 횟수, 3이라는 뜻은, 연속 3회 오류인 경우이다.
	         //따라서 3일 때 while문을 탈출해야하기 때문에 조건식이 false가 되어야한다.
	      }while(!stopedEngine && count != 3);
	 }
}
