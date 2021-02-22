package business;

public class CheckingAccount extends Account {
	private double monthlyFee;

	public CheckingAccount(double monthlyFee, double balance) {
		super();
		this.monthlyFee = monthlyFee;
		//setBalance(balance);
		this.balance = balance;
	}
	
	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public void subtractMonthlyFeeFromBalance() {
		balance -= monthlyFee;
	}
	
	
	
}
