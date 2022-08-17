package arrayListTask;

import java.util.ArrayList;

public class Restaurant {
	//음식 정보 DB
	//static을 써서 모든 객체가 공유할 수 있도록 선언
	//또한 객체화 없이 사용 가능
		public static ArrayList<Food> foods = new ArrayList<Food>();
		
		
	//음식 추가
		public void add(Food food) {
			foods.add(food);
		}
		
	//음식 종류 검사(문자열 리턴)
	//예) 스파케티 입력 시 "양식" 리턴
		
		public String checkKind(String name) {
			//입력 받은 name과 food.getName()이 같다면
			//해당 객체에 .getKind()로 접근하여 리턴
			//빠른 for문
			for (Food food : foods) {
				if(food.getName().equals(name)) {
					return food.getKind();
				}
			}
			return null;
		}
		
	//사용자가 원하는 종류의 음식 목록 조회(한 가지만 입력 가능)
	//한식 입력 시 한식만 조회
		public ArrayList<Food> findMenuList(String kind) {
			//몇개 담길 지 모르니 선별된 객체를 넣을 ArrayList 선언
			ArrayList<Food> wanted = new ArrayList<Food>();
			
			//빠른 for문
			for (Food food : foods) {
				//foods에서 food로 전달된 객체의 kind와 입력된 kind를 비교
				if(food.getKind().equals(kind)) {
					//둘이 같으면 새 ArrayList인 wanted에 food 추가
					wanted.add(food);
				}
			}
			//반복 끝나면 wanted 리턴. 리턴 타입은 ArrayList
			return wanted;
		}
		
	//음식의 종류 수정(가격 10% 상승)
	//한식 -> 중식, 가격은 10% 상승	
		
		public void changeKind(Food food) {
			//food와 food가 겹쳐서 food를 temp로 바꿈
			//빠른 for문
			for (Food temp : foods) {
				//temp의 name과 음식 종류가 새로 바뀌어 들어온 food 의 name 비교
				//이름 중복은 없을테니 이름이 같다면 temp의 kind를
				//새로 바뀐 food의 kind로 수정
				//temp의 price는 1.1 곱하는데 정수에 실수 곱하면 실수로 자동형변환되기
				//때문에 int를 붙혀서 강제 형변환 -> 소수점 잘림
				if(temp.getName().equals(food.getName())) {
					temp.setKind(food.getKind());
					temp.setPrice((int)(temp.getPrice()*1.1));
					break;
				}
			}
		}
		
	//사용자가 원하는 종류의 음식 개수 조회
		//예) 불고기, 제육볶음, 파스타, 초밥
		//한식 입력 시 2개
	
		public int findMenu(String kind) {
//			ArrayList<Integer> menuCounts = new ArrayList<Integer>();
			//종류 일치한 음식의 개수 담을 변수
//			int count = 0;
//			
//			for (Food food : foods) {
//				//입력된 kind와 일치하는 kind가 있다면 count가 1 증가
//				if(food.getKind().equals(kind)) {
//					count++;
//				}
//			}
//			//count 리턴. 타입은 int
//			return count;
			//대박. 점심 빨리 먹는 코드
			return findMenuList(kind).size();
		
		}
}
