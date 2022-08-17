package arrayListTask;

import java.util.ArrayList;
import java.util.Collections;

public class DataApp {

	//이상형 정보를 담을 DB
	
	
	public static ArrayList<Love> users = new ArrayList<Love>();
	
	//이상형 추가
	public void addDream(Love lover) {
		users.add(lover);
	}
	
	//사용자가 입력한 나이인 이상형 목록 조회
	
	public ArrayList<Love> searchList(int age) {
		//나이 입력
		//나이 검색
		//일치하는 객체 리턴
		//나이가 일치한 객체를 담을 새 ArrayList
		ArrayList<Love> selected = new ArrayList<Love>();
		//빠른 for문
		for (Love love : users) {
			//객체의 age와 입력된 age가 같으면 
			if(love.getAge()==age) {
				//if문으로 들어와서 selected에 해당 객체 저장
				selected.add(love);
			}
		}
		//리턴 타입은 ArrayList
		 return selected;
	}
	
	// 이상형의 나이 수정
	// 이상형의 번호를 추가하고 번호로 조회
	public void changeUserInfo(Love lovers) {
		//빠른 for문
		for (Love love : users) {
			//번호는 중복이 없으니 번호의 일치 여부를 확인하면
			//유일한 객체를 선별 가능
			if(love.getNumber() == lovers.getNumber()) {
				//해당 객체의 나이를 수정 완료된 lovers의 나이로 변경
				//수정 완료는 화면 쪽에서 처리
				//객체를 통째로 교체 -> 주소값이 달라짐
				users.set(users.indexOf(love), lovers);
				//객체는 그대로 두고 내부의 age에 접근하여 변경 -> 주소값 그대로
//				love.setAge(lovers.getAge());
				break;
			}
		}
		
		//number로 일치하는 이상형 조회
		//age로 나이를 수정
		
		
	}
	
	
	//이상형의 나이 순으로 재배치. 망한 코드
//		public ArrayList sortAge() {
//			//이상형들의 나이를 가져옴
//			// 나이를 오름차순 정렬
//			
//			ArrayList<Love> sorted = new ArrayList<Love>();
//			
//			for (int i = 0; i < users.size(); i++) {
//				if(users.get(i).getAge() > users.get(i+1).getAge()) {
//					sorted.add(users.get(i));
//				}else {
//					sorted.add(users.get(i+1));
//				}
//				if(sorted.get(i).equals(sorted.get(i+1))) {
//					sorted.remove(sorted.get(i));
//				}
//			}
//			return sorted;
//			
//		}
	//이상형의 나이 순으로 재배치. 강사님 코드
		public void sort() {
			ArrayList<Integer> ages = new ArrayList<>();
			ArrayList<Love> loves = new ArrayList<Love>();
			
			for (Love love : users) {
				ages.add(love.getAge());
			}
			
			Collections.sort(ages);

			for (int i = 0; i < users.size(); i++) {
				for (Love love : users) {
					if(ages.get(i) == love.getAge()) {
						loves.add(love);
					}
				}
			}
			users = loves;
		}
	
		public static void main(String[] args) {
			DataApp date = new DataApp();
			
			Love lover1 = new Love();
			Love lover2 = new Love();
			Love lover3 = new Love();
			Love lover4 = new Love();
			
			lover1.setName("김");
			lover1.setAge(32);
			lover1.setNumber(1);
			
			lover2.setName("정");
			lover2.setAge(22);
			lover2.setNumber(2);
			
			lover3.setName("강");
			lover3.setAge(42);
			lover3.setNumber(3);
			
			users.add(lover1);
			users.add(lover2);
			users.add(lover3);
			
			System.out.println(users);
			
			
			
			
		}
		
		
		
		
}




















