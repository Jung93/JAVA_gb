package bank;

public class Shinhan extends Bank{
	@Override
	//자식에서 재정의한 deposit()
	public void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
	}
}
