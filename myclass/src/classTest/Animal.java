package classTest;

import java.util.Random;

public class Animal {
//	String name, food;
//	int age, foodStock, life;
//	
//	public Animal(String name, String food, int age, int foodStock, int life) {
//		this.name = name;
//		this.food = food;
//		this.age = age;
//		this.foodStock = foodStock;
//		this.life = life;
//	}
//	
//	public Animal(int foodStock, int life) {
//		this.foodStock = foodStock;
//		this.life = life;
//	}
//
//	void eat() {
//			--this.foodStock;
//			++this.life;
//	}
//	
//	void sleep() {}
//	
//	
//	//외부에서 모든 문제를 전달 받는다.
//	//전달받은 문제 중 랜덤한 문제 한개를 리턴한다.
//	String walk() { 
//		Quiz quiz = new Quiz();
//		Random random = new Random();
////		String[] quizInformation = new String[5];
////		
////		for (int i = 0; i < quizInformation.length; i++) {
////			quizInformation[i] = quiz.quizzes[i]+quiz.answers[i];
////		}
//		String[] result = quiz.quizToWalk();
//		int randomNumber = random.nextInt(5);
//		return result[randomNumber];
//	
//	public static void main(String[] args) {
//		
//		String quizOne = "다음 중 날개가 있는 동물은?\n1.붕어\n2.기린\n3.독수리";;
//		String quizTwo = "여름에 시원하게 수영하고 싶을 때 가는 곳은?\n1.불가마\n2.수영장\n3.축구장";
//		String quizThree = "다음 중 공을 발로 차면서 노는 놀이는?\n1.축구\n2.골프\n3.클라이밍";
//		String quizFour = "2+2X2 = ?\n1. 6\n2. 8\n3. 10";
//		String quizFive = "사람들이 모여 앉아 다같이 영화를 보는 곳은?\n1.도서관\n2.우리집\n3.영화관";
//		
//		String[] quizDatas = {quizOne,quizTwo,quizThree,quizFour,quizFive};
//		int[] answers = {3,2,1,1,3};
//		int[] foodStocks = {1,1,1,1,1};
//		String startMsg = "동물 친구를 골라주세요\n1. 토끼\n2. 고라니\n3. 코끼리";
//		String namingMsg = "친구의 이름은 무엇인가요?";
//		String ageMsg = "친구는 몇 살인가요?";
//		String menuMsg = "친구와 무엇을 할까요?\n1. 먹기\n2. 자기\n3. 산책하기\n4. 작별 인사하기";
//		String exitMsg = "다음에 또 만나!", resultMsg = null;
//		String name = null;
//		int choice = 0, age = 0;
//		
//		Animal aFriend = new Animal(10,5);
//		Scanner sc = new Scanner(System.in);
//		Quiz quest = new Quiz(quizDatas, answers, foodStocks);
//		
//		System.out.println(startMsg);
//		choice = sc.nextInt();
//		System.out.println(namingMsg);
//		name = sc.next();
//		System.out.println(ageMsg);
//		age = sc.nextInt();
//		
//		
//		
//		
//		
//		
//		while(choice !=4) {
//		System.out.println(menuMsg);
//		choice = sc.nextInt();
//		
//		switch(choice) {
//		case 1:
//			if(aFriend.foodStock>0) {
//				aFriend.eat();
//				resultMsg = "남은 먹이: "+aFriend.foodStock + "개\n"
//								
//							+"생명: "+aFriend.life+"개";
//			}else {
//				resultMsg = "먹이가 부족해요";
//			}
//			System.out.println(resultMsg);
//			
//			
//			
//			break;
//		case 2:
//			System.out.println("추후 업데이트 예정");
//			break;
//		case 3:
//			System.out.println(aFriend.walk());
//				
//			
//			break;
//		
//		
//		}
//		
//		
//		}
//		System.out.println(exitMsg);
//	}
	
	
	String name;
	int age;
	String feed;
	int feedCount;
	int life;
	
	public Animal() {;}
	
	public Animal(String name, int age, String feed, int feedCount, int life) {
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}
	
	void eat() {
		feedCount--;
		life++;
	}
	
	void sleep() {
		life++;
	}
	Quiz walk(Quiz[] quizes) {
		life--;
		//random
		Random r = new Random();
		return quizes[r.nextInt(quizes.length)];
	}
	
}
