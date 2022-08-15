package myBank;

public class KB extends Bank {
	
	@Override
	public void withdraw(int money) {
		money *= 1.5;
		super.withdraw(0);
	}
}
