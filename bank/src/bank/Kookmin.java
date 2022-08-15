package bank;

public class Kookmin extends Bank{
	@Override
	//자식에서 재정의한 withdraw()
	public void withdraw(int money) {
		money *= 1.5;
		super.withdraw(money);
	}
}
