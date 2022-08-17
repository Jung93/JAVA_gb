package arrayListTask;

public class Fruit {
	//과일 이름, 가격
	//private
	//기본 생성자
	//toString() 재정의
	
	//객체의 이름과 가격
	private String fruitName;
	private int price;
	
	//기본 생성자
	public Fruit() {;}
	
	//private에 접근하기 위한
	//getter와 setter
	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//toString 재정의
	@Override
	public String toString() {
		String str = fruitName+", "+price;
		return str;
	}
}
