package myMarkerInterfaceTest;

public class Lab {
	
	
	//외부에서 모든 동물을 받아와서 초식인지 육식인지 잡식인지 
	//구분하는 메소드
	//초식 동물 : Herbivore
	//육식 동물 : Carnivore
	public static void checkKinds(Animal[] animals) {
		//외부에서 Animal 타입의 배열을 전달받고
		//instanceof를 사용하여 종을 검사

		//모든 동물을 비교해야 하니 animal의 수만큼 반복
		for (int i = 0; i < animals.length; i++) {
			//마커 인터페이스를 implements 했기 때문에 
			//해당 인터페이스와 타입이 같은지 다른지 비교할 수 있음.
			//cow, tiger, bear의 Animal 이외의 공통점으로 각각 묶은 것.
			//초식	: cow
			//육식 : tiger, bear
			//잡식 : dog
			if(animals[i] instanceof HerbivoreMarker) {
				System.out.println("초식동물입니다.");
			}else if(animals[i] instanceof CarnivoreMarker) {
				System.out.println("육식동물입니다.");
			}else {
				System.out.println("잡식동물입니다.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		//업캐스팅. Cow타입의 객체가 Animal 타입의 배열로 들어가면서 업캐스팅.
		Animal[] animals = {new Cow(), new Bear(), new Tiger(), new Dog()};
		
		//checkKinds 메소드에 static 써서 바로 접근 가능
		Lab.checkKinds(animals);
		
	}
}
