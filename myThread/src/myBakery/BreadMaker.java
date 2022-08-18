package myBakery;

public class BreadMaker extends BreadPlate implements Runnable{

	@Override
	public void run() {
		//빵을 20개 만든다

		for (int i = 0; i < 20; i++) {
			make();
		}
	}
}
