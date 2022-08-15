package myBank;

public class Sachae extends Bank {
	
	@Override
	   public int showBalance() {
	      setMoney(getMoney() / 2);
	      return super.showBalance();
	   }
}
