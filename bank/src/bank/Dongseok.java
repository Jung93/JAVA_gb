package bank;

public class Dongseok extends Bank{
	@Override
	//자식에서 재정의한 showBalance()
	public int showBalance() {
		setMoney(getMoney() / 2);
		return super.showBalance();
	}
}
