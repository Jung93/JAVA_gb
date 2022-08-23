package casting;

class Car{
	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
}
//캐스팅을 위해 상속
class SuperCar extends Car{
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
	}
	
	void openRoof() {
		System.out.println("지붕 열기");
	}
	
}


public class CastingTest {
	public static void main(String[] args) {
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		//up casting
		//자식이 부모 타입이 됨
		Car noOptionFerrari = new SuperCar();
		
		//down casting
		//up casting되었던 부모만 원래 자식 타입으로 돌아갈 수 있음
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		
		//오류
//		SuperCar brokenFerrai = (SuperCar)new Car();
		
//		matiz instanceof Car : true
		//instanceof 객체의 타입을 비교
		System.out.println(matiz instanceof Car);
//		matiz instanceof SuperCar : false
		System.out.println(matiz instanceof SuperCar);
//		ferrari instanceof Car : true
		System.out.println(ferrari instanceof Car);
//		ferrari instanceof SuperCar : true
		System.out.println(ferrari instanceof SuperCar);
//		noOptionFerrari instanceof Car : true
		System.out.println(noOptionFerrari instanceof Car);
//		noOptionFerrari instanceof SuperCar : true
		System.out.println(noOptionFerrari instanceof SuperCar);
//		fullOptionFerrari instanceof Car : true
		System.out.println(fullOptionFerrari instanceof Car);
//		fullOptionFerrari instanceof SuperCar : true
		System.out.println(fullOptionFerrari instanceof SuperCar);
		
	}
}





















