package bank;

public class Bank {
	//은행 3개, 각 은행 당 100개의 고객정보를 관리할 2차 배열 선언. 3행 100열
	 //은행이 3개, 각 은행별 고객 100명씩 유치가능
	public static Bank[][] arrBank = new Bank[3][100];
	 //계좌가 개설된 정보만 찾기 위한 배열 (?)  
	//은행별 가입 회원 수
	 public static int[] arCount = new int[3];
	   
	 	//private을 써서 메소드를 사용해야한 접근 가능하도록 설정.
	   private String name;
	   private String account;
	   private String phoneNumber;
	   private String password;
	   private int money;
	   
	   //초기화 생성자를 선언하면 기본 생성자가 사라지므로 
	   //상속을 위해 기본 생성자도 따로 선언
	   public Bank() {;}

	   //초기화 생성자
	   public Bank(String name, String account, String phoneNumber, String password, int money) {
	      this.name = name;
	      this.account = account;
	      this.phoneNumber = phoneNumber;
	      this.password = password;
	      this.money = money;
	   }

	   //private으로 감싸진 변수에 접근하기 위한 getter와 setter
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getAccount() {
	      return account;
	   }

	   public void setAccount(String account) {
	      this.account = account;
	   }

	   public String getPhoneNumber() {
	      return phoneNumber;
	   }

	   public void setPhoneNumber(String phoneNumber) {
	      this.phoneNumber = phoneNumber;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public int getMoney() {
	      return money;
	   }

	   public void setMoney(int money) {
	      this.money = money;
	   }
	 //여기까지 각 변수에 대한 getter, setter
	   
	   
	   //static을 붙여서 선언한 메소드
	   //객체화 없이 사용해야 할 때가 있기 때문
	   //객체화 없이 사용하면 편하기 때문
	   
	//   계좌번호 중복검사
	   //static을 사용하여 메모리 Data 영역에 할당
	   //리턴타입은 Bank
	   //외부에서 생성된 계좌번호를 전달받는다.
	   public static Bank checkAccount(String account) {
	      Bank bank = null;
	      //arrBank의 행의 길이만큼 반복
	      for (int i = 0; i < arrBank.length; i++) {//은행 수만큼 반복
	         //for문 바깥에서도 쓰기 위해 j 선언하고 초기화
	    	  int j = 0;
	    	  //계좌가 있는만큼 arCount만큼 반복?(?)
	         for (j = 0; j < arCount[i]; j++) {// 각 은행별 가입된 회원 수 만큼 반복
	        	 //arrBank 안에 있는 값과 전달받은 account가
	        	 //같은지 확인
	            if(arrBank[i][j].account.equals(account)) {//각 회원들의 계좌번호와 생성된 계좌번호를 비교
	               //만약 일치하는 번호가 있다면 해당 객체를 bank에 담아준다
	            	bank = arrBank[i][j];
	            	//더 이상 반복을 진행할 필요가 없다.
	               break;
	            }
	         }
	         //위에서 강제로 break를 했다묜 j가 acCount[i]까지 증가하지 못하기 때문에
	         //위에서 break 후 밖에 있는 for문도 break해준다.
	         if(j != arCount[i]) {break;}
	      }
	      return bank;
	   }
	//   핸드폰 번호 검사
	   
	   public static Bank checkPhoneNumber(String phoneNumber) {
	      Bank bank = null;
	      for (int i = 0; i < arrBank.length; i++) {
	         int j = 0;
	         for (j = 0; j < arCount[i]; j++) {
	            if(arrBank[i][j].phoneNumber.equals(phoneNumber)) {
	               bank = arrBank[i][j];
	               break;
	            }
	         }
	         if(j != arCount[i]) {break;}
	      }
	      return bank;
	   }
	//   로그인
	   //리턴 타입은 Bank
	   public static Bank login(String account, String password) {
	      //Bank 클래스의 checAccount() 사용
		   //전달 받은 매개벼수를 그대로 메소드에 전달
		   //계좌번호는 checkAccount에 전달
		   //계좌가 있다면 해당 회원의 전체 정보를 가져온다
		   // 계좌가 없다면 null을 가져온다
		   Bank bank = checkAccount(account);
		   //checkAccount가 null이 아닐 경우.
		   //login시 아이디 입력하는 것. null이 아니라는 것은 아이디가 일치
	      
		   if(bank != null) {
	    	  //bank가 Bank 타입의 객체이기 때문에
	    	  //bank.password하면 this.password를 쓸 수 있음
	    	  //bank.name 등도 마찬가지
	    	  //id가 일치해도 비번이 틀리면 안되니까 비번도 같은지 확인
			   //그 회원의 비밀번호와 입력받은 비밀번호 비교
	         if(bank.password.equals(password)) {
	        	 //로그인 성공시, 회원의 전체 정보를 리턴
	        	 return bank;
	         }
	      }
		   //로그인 실패 시 null 리턴
	      return null;
	   }
	//   입금
	   //모든 곳에서 접근을 허용하는 public
	   //this.money에 전달받은 money를 더하고 저장
	   public void deposit(int money) {
	      this.money += money;
	   }
	//   출금
	 //this.money에서 전달받은 money를 빼고 저장
	   public void withdraw(int money) {
	      this.money -= money;
	   }
	//   잔액조회
	 //this.money을 리턴
	   public int showBalance() {
	      return money;
	   }
}//class
