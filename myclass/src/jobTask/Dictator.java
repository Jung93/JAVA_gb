package jobTask;

import java.util.Random;

public class Dictator {

	String name;
	String id;
	String password;
	int acount;
	int follower;
	//int count;
	//Random 클래스 객체화
	Random r = new Random();
	
	//다 받아오는 생성자
	public Dictator(String name, int acount, int follower) {
		super();
		this.name = name;
		this.acount = acount;
		this.follower = follower;
	}
	//초기화 생성자
	public Dictator() {
		this.acount = 5000;
		this.follower = 50;
	}
	//100단위로 확률 구현하기
	boolean percent(int rate) {
		//100단위니까 100칸 배열
		int[] percent = new int[100];
		//rate만큼 1 넣기 반복. 10단위와 달리 10으로 나눌 필요 없음
		for (int i = 0; i < rate; i++) {
			percent[i] = 1;
		}
		//들어간 1만큼 1이 나올 확률이 정해짐
		return percent[r.nextInt(percent.length)] == 1;
	}
	
	//embezzle 메소드 선언부
	boolean embezzle() {
		if(percent(66)) {
			acount+=500;
			return true;
		}
		follower-= 5;
		return false;
	}
	//invade 메소드 선언부
	boolean invade() {
		if(percent(33)) {
			acount+= 3_000;
			follower+= 20;
			return true;
		}
		acount -= 1000;
		follower -= 10;
		return false;
	}
	//밸런스 잡기 어렵네ㅠ
}
