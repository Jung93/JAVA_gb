package myAnonymousTask;

public class Building {
	public static void main(String[] args) {
		//잠실점 오픈
		//잠실점은 무료 나눔 행사 중이라서 판매 방식 구현할 필요 없다
		//본사에서는 전달받은 양식을 검사할 때
		//무료 나눔 행상중인 매장이라면 "무료 나눔 행사중" 출력하기
		
		//Starbuck를 객체화
		Starbucks gangnam = new Starbucks();
		//gangnam의 register 메소드에 접근
		//Form()은 인터페이스 생성자. 익명클래스가 구현되지 않은 필드를 구현하기 위해
		//열림. 열리며 인터페이스를 지정받아 sell()과 getMenu()를 재정의하도록 가져옴
		gangnam.register(new Form() {
			
			//sell을 재정의
			@Override
			public void sell(String order) {
				//재정의된 getMenu()를 menus에 저장
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if(order.equals(menus[i])) {
						System.out.println("판매 완료");
					}
				}
			}
			
			//String타입의 배열을 리턴하는 메소드
			@Override
			public String[] getMenu() {
				//메뉴를 String[]으로 만들고 리턴
				String[] menus = {"아메리카노", "카푸치노","캐모마일티"};
				return menus;
			}
		});
		
		
		Starbucks jamsil = new Starbucks();
		//원하는 메소드만 재정의하기 위해 FormAdapter() 사용
		//FormAdapter라는 추상 클래스는 Form을 지정받기 때문에
		//Form의 추상 메소드를 재정의할 수 있음
		//강제성을 없애기 때문에 익명 클래스가 열렸을 때 원하는 것만 재정의 가능
		jamsil.register(new FormAdapter() {
			
			@Override
			public String[] getMenu() {
				String[] menus = {"아메리카노", "초코라테","사다수"};
				return menus;
			}
			
		});
		
		
	}
}
