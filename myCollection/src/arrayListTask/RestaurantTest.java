package arrayListTask;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantTest {
	public static void main(String[] args) {
		
		Restaurant rest = new Restaurant();
		
		
		Scanner sc = new Scanner(System.in);
		
//		ArrayList<Food> foods = new ArrayList<Food>();
//		Food[] foods = {new Food(), new Food(),new Food(), new Food()};
		
		while(true) {
			System.out.println("1. 음식 추가\n2. 종류 검색\n3. 목록 조회\n4. 종류 수정\n5. 개수 조회\n6. 나가기");
			
			Food food = new Food();
			int choice = sc.nextInt();
			if(choice==6) {break;}
			
			switch(choice) {
			
			case 1://음식 추가
			System.out.print("음식 이름 : ");
			food.setName(sc.next());
			System.out.print("음식 종류 : ");
			food.setKind(sc.next());
			System.out.print("음식 가격 : ");
			food.setPrice(sc.nextInt());
			
			rest.add(food);
			break;
			
			case 2:
				System.out.println(rest.checkKind(sc.next()));
				break;
			case 3:
				System.out.println(rest.findMenuList(sc.next()));
				break;
			case 4:
				for (Food foodChange : rest.foods) {
						if(foodChange.getName().equals(sc.next())) {
							foodChange.setKind(sc.next());
							rest.changeKind(foodChange);
							break;
						}
				}
				System.out.println(rest.foods);
				break;
			case 5:
				System.out.println(rest.findMenu(sc.next()));
				break;
			}
		}
//		System.out.println("menu입니다");
//		System.out.println(rest.foods);
		
//		Food bulgogi = new Food();
//		Food spagetii = new Food();
//		Food chobab = new Food();
//		Food tangsuuk= new Food();
//		Food kimbab = new Food();
		
//		bulgogi.setName("불고기");
//		bulgogi.setKind("한식");
//		bulgogi.setPrice(1000);
//		spagetii.setName("스파게티");
//		spagetii.setKind("양식");
//		spagetii.setPrice(2000);
//		chobab.setName("초밥");
//		chobab.setKind("일식");
//		chobab.setPrice(3000);
//		tangsuuk.setName("탕수육");
//		tangsuuk.setKind("중식");
//		tangsuuk.setPrice(4000);
//		kimbab.setName("김밥");
//		kimbab.setKind("한식");
//		kimbab.setPrice(5000);
		
//		rest.foods.add(bulgogi);
//		rest.foods.add(spagetii);
//		rest.foods.add(chobab);
//		rest.foods.add(tangsuuk);
//		rest.foods.add(kimbab);
		
//		System.out.println(rest.foods);
		
//		System.out.println(rest.checkKind("스파게티"));
		
//		System.out.println(rest.findMenuList("양식"));
		
//		System.out.println(rest.foods);
//		bulgogi.setKind("양식");
		
//		rest.changeKind(bulgogi);
		
//		System.out.println(rest.foods);
		
//		System.out.println(rest.findMenu("한식"));;
		
		
		
		
		
	}
}
