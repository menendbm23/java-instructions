import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculator2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the tip calculator!");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		//Cost of meal
		System.out.println("Enter cost of meal: ");
		String mealcostString = sc.next();
		
		BigDecimal mealCost = new BigDecimal(mealcostString);
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		
		BigDecimal tipPercent15 = new BigDecimal("1.15");
		BigDecimal tipPercent20 = new BigDecimal("1.20");
		BigDecimal tipPercent25 = new BigDecimal("1.25");
		
		BigDecimal tipPercent1 = mealCost.multiply(tipPercent15).subtract(mealCost)
				.setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal totalAfterTax1 = mealCost.multiply(tipPercent15)
				.setScale(2, RoundingMode.HALF_UP);
		System.out.println("15%");
		System.out.println("Tip Amount: " +currency.format(tipPercent1));
		System.out.println("Total Amount: " +currency.format(totalAfterTax1));
		
		BigDecimal tipPercent2 = mealCost.multiply(tipPercent20).subtract(mealCost)
				.setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal totalAfterTax2 = mealCost.multiply(tipPercent20)
				.setScale(2, RoundingMode.HALF_UP);
		System.out.println("20%");
		System.out.println("Tip Amount: " +currency.format(tipPercent2));
		System.out.println("Total Amount: " +currency.format(totalAfterTax2));
		
		
		BigDecimal tipPercent3 = mealCost.multiply(tipPercent25).subtract(mealCost)
				.setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal totalAfterTax3 = mealCost.multiply(tipPercent25)
				.setScale(2, RoundingMode.HALF_UP);
		System.out.println("25%");
		System.out.println("Tip Amount: " +currency.format(tipPercent3));
		System.out.println("Total Amount: " +currency.format(totalAfterTax3));
		
		
		System.out.println("Continue? y/n: ");
		choice = sc.next();
		System.out.println();
		
		}	
		
		System.out.println("Bye!");

	}

}