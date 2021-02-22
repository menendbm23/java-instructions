package business;

public class SavingsAccount extends Account {
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double monthlyInterestRate, double balance) {
		super();
		this.monthlyInterestRate = monthlyInterestRate;
		this.balance = balance;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}

	public void setMonthlyInterestPayment(double monthlyInterestPayment) {
		this.monthlyInterestPayment = monthlyInterestPayment;
	}
	
	public void applyPaymentToBalance() {
		//calculate payment (sa balance * interest rate)
		monthlyInterestPayment = balance * monthlyInterestRate;
		balance += monthlyInterestPayment;
	}
	
}
