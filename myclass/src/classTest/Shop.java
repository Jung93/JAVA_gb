package classTest;

import java.util.Scanner;

class SuperCar {
	Scanner sc = new Scanner(System.in);
//  브랜드, 색상, 가격
  
	String brand;
	String color;
	String result = null;
	int price;
	int password;
	boolean check;
	
public SuperCar(String brand, String color, int price, int password) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.password = password;
	}

//  시동 켜기
//  시동의 상태를 확인하고 
//  시동이 꺼져있다면, "시동 켜기" 출력
//  이미 시동이 켜져있다면, "시동이 이미 켜져있습니다" 출력
	String engineStart() {
		if(!check) {
			result = brand + " 시동켜기";
			check=true;
		}else {
			result = brand + "의 시동이 이미 켜져있습니다";
		}
		return result;
	}
//  시동 끄기
//  시동의 상태를 확인하고 
//  시동이 켜져있다면, "시동 끄기" 출력
//  이미 시동이 꺼져있다면, "시동이 이미 꺼져있습니다" 출력
	String engineStop() {
		if(check) {
			result = brand + " 시동끄기";
			check = false;
		}else {
			result = brand + "의 시동이 이미 꺼져있습니다";
		}
		return result;
	}
		String verifyPassword(){
			int count = 2, pw = 0;
			
			for (int i = 0; i < 3; i++) {
				pw = sc.nextInt();
				
				if(password == pw) {
					result = "환영합니다 차주님";
					break;
				}else{
					
					result = "비밀 번호를 다시 입력해 주십시오"+count+"회 남음";
					count--;
				}
					
					
			
			}
			return result;
				
		  }
			
		}
	
	//[심화]
	// 시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
	// 입력한 비밀번호가 3회 '연속' 실패하면 "경찰 출동" 메세지를 출력한다.


public class Shop {
	public static void main(String[] args) {
		SuperCar singsingee = new SuperCar("모닝", "white", 1_000, 4039); 
		
		
		

		
	}
}
