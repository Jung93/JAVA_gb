package myBakery;

public class BreadPlate {
	//빵 만들기
	//만든 빵이 9개가 넘어가면, 쓰레드를 멈춰준다. wait()
	public int count;
	
	public void make() {
		++count;
		if(count>9) {try {this.wait();} catch (InterruptedException e) {;}}
	}
	
	//먹기
	//만든 빵이 0개면 못 먹고, 먹은 빵이 20개면 못 먹는다.
	//만약 빵을 먹게 되면, 멈춰있던 쓰레드를 깨워준다.
	
	public void eat() {
		--count;
		this.notify();
	}
}
