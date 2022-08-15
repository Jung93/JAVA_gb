package classTest;


public class Quiz {
//	//문제, 정답, 먹이개수
//
////	String quizOne = "다음 중 날개가 있는 동물은?\n1.붕어\n2.기린\n3.독수리";;
////	String quizTwo = "여름에 시원하게 수영하고 싶을 때 가는 곳은?\n1.불가마\n2.수영장\n3.축구장";
////	String quizThree = "다음 중 공을 발로 차면서 노는 놀이는?\n1.축구\n2.골프\n3.클라이밍";
////	String quizFour = "2+2X2 = ?\n1. 6\n2. 8\n3. 10";
////	String quizFive = "사람들이 모여 앉아 다같이 영화를 보는 곳은?\n1.도서관\n2.우리집\n3.영화관";
//	
//	String[] quizzes;
//	int[] answers;
//	int[] foodStock;
//	
//	public Quiz(String[] quizzes, int[] answers, int[] foodStock) {
//		this.quizzes = quizzes;
//		this.answers = answers;
//		this.foodStock = foodStock;
//	}
//
//	public Quiz() {
//		
//	}
//	String[] quizToWalk() {
//		return this.quizzes;
//	}
//	
//
//	
//	
//	
//	//main 메소드에서 퀴즈의 내용을 입력하고
//	//Quiz 클래스에서 퀴즈의 공통내용(퀴즈, 정답, 먹이개수)을 적고
//	//walk() 에서 공통내용을 배열로 받아와서 랜덤한 값 전달
//	
	String question;
	String answer;
	int feedCount;
	
	public Quiz() {;}
	
	public Quiz(String question, String answer, int feedCount) {
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
	}
	

}

