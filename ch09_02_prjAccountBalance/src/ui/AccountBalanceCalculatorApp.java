package ui;
import java.text.NumberFormat;

import business.Account;
import business.CheckingAccount;
import business.SavingsAccount;
import util.Console;

public class AccountBalanceCalculatorApp {
	static NumberFormat currency = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		System.out.println("Welcome to the Account application \n");
		//Initialization - create new accounts and display balances
		CheckingAccount ca = new CheckingAccount(1,1000);
		SavingsAccount sa = new SavingsAccount(.01,1000);
		
		System.out.println("Starting Balances");
		displayBalances(ca, sa);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			Account a = null;
			
			String trans = Console.getChoiceString("Withdraw or Deposit? (w/d): ", "w", "d");
			
			String type = Console.getChoiceString("Checking or Savings? (c/s): ", "c", "s");
			
			double amount = Console.getDouble("Amount? ");
			
			if (type.equalsIgnoreCase("c")) {
				a = ca;
			}
			else if (type.equalsIgnoreCase("s")) {
				a = sa;
			}
			
			if (trans.equalsIgnoreCase("w")) {
				if (amount > a.getBalance()) {
					System.out.println("Cannot withdraw more than your balance");
				}
				else {
					a.withdraw(amount);
				}
				
			}
			else if (trans.equalsIgnoreCase("d")) {
				a.deposit(amount);
			}
				
			choice = Console.getChoiceString("Continue? (y/n): ", "y", "n");
			
		}
		
		ca.subtractMonthlyFeeFromBalance();
		sa.applyPaymentToBalance();
		System.out.println("Monthly Payments and Fees:");
		System.out.println("Checking Fee:             "+currency.format(ca.getMonthlyFee()));
		System.out.println("Savings Interest Payment: "+currency.format(sa.getMonthlyInterestPayment()));
		System.out.println();
		System.out.println("Final Balances:");
		displayBalances(ca, sa);
		
		
		System.out.println("Bye!");
		

	}
	
	private static void displayBalances(CheckingAccount ca, SavingsAccount sa) {
		System.out.println("Checking: "+currency.format(ca.getBalance()));
		System.out.println("Savings: "+currency.format(sa.getBalance()));

		
	}
}



