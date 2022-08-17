package arrayListTask;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Market{
	//과일을 저장할 DB 선언
	// 과일 추가
	public static ArrayList<Fruit> fruits = new ArrayList<>();
	
		
	
		public void addFruit(Fruit fruitInfo) {
			//이름과 가격을 Fruit으로 받아오기
			//그 정보를 ArrayList로 add()로 넣어줌
			
			fruits.add(fruitInfo);
		}
		
	// 과일 삭제
		
//		public void removeFruit(Fruit fruitInfo) {
//			//과일삭제
//			//과일의 이름으로 삭제
//			//과일의 이름을 외부에서 전달받는다
//			//DB에서 과일의 이름을 검색한다.
//			//과일의 이름이 검색되면 해당 객체를 저장한다.
//			//저장한 객체를 DB에서 삭제한다.
//			
//			//fruitInfo 객체를 받아와서
//			//객체의 아이디를 검색해서
//			//fruits에서 일치하는 객체 삭제
//			//System.out.println(fruits.indexOf(fruitInfo.getFruitName())); -1
//			
//			for (int i = 0; i < fruits.size(); i++) {
//				Fruit fruit = null;
//				
//				if(fruits.get(i).getFruitName().equals(fruitInfo.getFruitName())) {
//					fruit = fruits.get(i);
//				}
//					fruits.remove(fruit);
//			}
//		}
		
		//빠른 for문에서 반복자 자리(fruits)에 있는 객체의 데이터에 변화가 생기면
		//반복에 대한 기준점이 수정되는 것이므로 오류가 발생한다.
		//try catch문으로 감싸면 된다.
		public void removeFruit(String name) {
			try {
				for (Fruit fruit : fruits) {
					if(fruit.getFruitName().equals(name)) {
						fruits.remove(fruit);
						//위 주석대로 오류가 발생하기 때문에 break로 if문을 탈출
						//반복을 끝내어 오류를 방지한다.
						//break;
						//아니면 현재 작성되어있는 거처럼 try catch로 잡던가
					}
				}
				//해당 오류 잡고 실행은 아무것도 안함
			} catch (ConcurrentModificationException e) {;}
		}
		
		//과일의 가격이 평균 가격보다 낮은 지 검사
		
		public boolean checkPrice(int price) {
			//fruits의 객체의 가격들이 필요
			//가져온 가격들의 총합/ 개수(size) -> 평균
			//전달 받은 객체와 평균의 크기를 비교
			//결과에 따라 리턴이 달라짐
//			int sum = 0;
//			double average = 0.0;
//			boolean check = false;
			
//			for (int i = 0; i < fruits.size(); i++) {
//				sum+= fruits.get(i).getPrice();
//			}
			//빠른 for문
			//반복자(fruits)가 fruitPrice로 하나씩 들어가면서 반복
//			for (Fruit fruitPrice : fruits) {
				//fruits에서 fruitPrice로 객체 하나가 전달되니까
				//객체의 주소로 접근해서 getPrice() 사용하고
				//같은 int 타입인 sum으로 더하기 연산
//				sum += fruitPrice.getPrice();
//			}
			//반복이 끝난 sum을 double타입으로 형변환하면서 평균 구함
//			average = sum/(double)fruits.size();
			
			//평균과 전달받은 객체의 price의 크기 비교
			//전달받은 객체의 크기가 평균보다 작으면 true, 평균보다 크거나 같으면 false 
			//boolean 타입 check에 삼항의 결과 저장
//			check = average > price ? true : false;
			//삼항 그딴 거 필요없다.
			//비교 연산자 자체가 true false 둘 중 하나니까 그냥 return하면
			//알아서 boolean 타입이다.
			//강사님의 이런 센스를 따라잡자
//			return average > price;
			
			//ㅠㅠ나도 이런 코드 혼자 짜보고 싶당
			return getAverage() > price;
		}
		
		public double getAverage() {
//			평균 구하느 메소드 만들고 그 결과를 checkPrice에서 사용하는 방법
			int total = 0;
			
			for (Fruit fruit : fruits) {
				total += fruit.getPrice();
			}
			//차피 double 타입이니까 average 변수 double 타입으로 선언해서
			//저장할 필요 딱히 없음
			return Double.parseDouble(String.format("%.2f", total/(double)fruits.size()));
		}
		
		public static void main(String[] args) {
			
			Market m = new Market();
			Fruit f1 = new Fruit();
			Fruit f2 = new Fruit();
			Fruit f3 = new Fruit();
			
			f1.setFruitName("banana");
			f1.setPrice(5000);

			f2.setFruitName("apple");
			f2.setPrice(4000);
			
			f3.setFruitName("banana");
			f3.setPrice(3000);
			
			
			m.addFruit(f1);
			m.addFruit(f2);
			m.addFruit(f3);
			
			System.out.println(fruits);
			
			System.out.println(m.checkPrice(3000));
			System.out.println(m.checkPrice(2000));
			System.out.println(m.checkPrice(4000));
			
			m.removeFruit("banana");
//			System.out.println(f1.getFruitName());
			System.out.println(fruits);
		}
}
