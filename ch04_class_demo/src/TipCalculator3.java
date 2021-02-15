import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculator3 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator");
		Scanner sc = new Scanner ("y");
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Cost of Meal? ");
			BigDecimal costOfMeal = sc.nextBigDecimal();
			
			NumberFormat percent = NumberFormat.getPercentInstance();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			
			
			for (double d = .15; d <= .25; d+=.05) {
			System.out.println(percent.format(d));
			BigDecimal tipPct = new BigDecimal(d);
			BigDecimal tipAmt = costOfMeal.multiply(tipPct);
			System.out.println("Tip Amount:\t"+currency.format(tipAmt));
			BigDecimal total = costOfMeal.add(tipAmt);
			System.out.println("Total Amount:\t"+currency.format(total));
			
			}
			System.out.println("Continue? (y/n)");
			choice = sc.next();
			

	}

	}
	
}



