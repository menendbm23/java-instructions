package business;

public class Account implements Depositable, Balanceable, Withdrawable {

	protected double balance;
	
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;

	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

}
