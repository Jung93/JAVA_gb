package myAnonymousTask;


public class Starbucks{
	
	//매개변수를 Form 타입으로 받음 
	public void register(Form form) {
		//Building 클래스에서 생성자로 FormAdapter()를 쓸 경우
		//업캐스팅된 Form에는 FormAdapter의 getMenu()가 재정의 됨
		String[] menus = form.getMenu();

		//따라서 menus를 반복 돌리면 재정의된 메뉴들이 나옴 
		System.out.println("===메뉴===");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i+1+". "+menus[i]);
		}
		
		//Building 클래스에서 생성자로 FormAdapter()를 쓸 경우
		//form과 FormAdapter의 타입이 Form으로 같기 때문에
		//if문 안쪽으로 들어간다.
		if(form instanceof FormAdapter) {
				System.out.println("무료");
		}
	}
}
