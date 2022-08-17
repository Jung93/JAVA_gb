package arrayListTask;

public class Food {
	//음식 이름 ,가격, 종류(한 일 양 중)
	//private
	//기본
	//toString
	
	private String name;
	private String kind;
	private int price;
	
	public Food() {;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + ", " + kind + ", " + price;
	}
}
