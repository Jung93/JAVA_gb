package classTest;

import java.util.Scanner;

public class Zoo {
	public static void main(String[] args) {
		Animal[] animals = {
				new Animal("코끼리", 120, "건초", 2, 8),
				new Animal("토끼", 3, "당근", 8, 2),
				new Animal("타조", 5, "지렁이", 5, 5)
		};
		
		Quiz[] quizes = {
				new Quiz("Q. 바나나를 엄마가 사왔어요.\n 형이 3개 먹고 내가 5개를 먹었더니 1개 남았어요.\n 엄마가 사온 바나나의 몇개 였을까요? ", "9", 10),
				new Quiz("Q. 다음 어린이 중 누가 착한 행동을 했을까요?\n1. 요구르트를 훔친 철수\n2. 친구를 바닥에 눕힌 영희\n3. 늦게 왔으면서 수업에 딴짓까지 하는 동석\n4. 엄마 어깨를 안마해주는 유리", "4", 2),
				new Quiz("Q. 횡단보도를 건널 수 있는 방법을 고르세요\n1. 빨간불에 건넌다\n2. 뛰어간다\n3. 손을 들고 초록불에 건넌다\n4. 핸드폰을 보면서 건넌다", "3", 5)
		};
		
		Scanner sc = new Scanner(System.in);
		
		String title = "★☆모여라 셀럽동물☆★";
		String menuMessage = "안녕하세요 여러분!\n 동물친구를 선택해보세요.\n1. 코끼리\n2. 토끼\n3. 타조\n4. 나가기";
		String actionMessage = "1.먹기\n2.잠자기\n3.산책하기\n4. 작별인사하기";
		int characterNumber = 0,actionChoice = 0;
		
		while(true) {
			System.out.println(title);
			System.out.println(menuMessage);
			characterNumber = sc.nextInt();
			if(characterNumber ==4) {break;}
			
			while(true) {
				System.out.println(actionMessage);
				actionChoice = sc.nextInt();
				if(actionChoice==4) {break;}
				
				//animal의 타입이 Animal
				Animal animal = animals[characterNumber-1];
				
				switch(actionChoice) {
				case 1://먹기
					if(animal.feedCount > 0) {
						animal.eat();
						System.out.println("냠냠 맛있어!");
						System.out.println(animal.name +"의 체력: "+animal.life);
						System.out.println(animal.name +"의 먹이: "+animal.feedCount+"개");
						break;
					}
					System.out.println(animal.feed + "이(가) 부족해요ㅠㅠ\n퀴즈를 풀어서 먹이를 획득하세요!");
					break;
				case 2://잠자기
						
					
					break;
				case 3://산책하기
					break;
				default:
					break;
				}
			}
		}
	
	}
}
