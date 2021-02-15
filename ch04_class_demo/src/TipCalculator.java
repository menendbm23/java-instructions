import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the tip calculator!");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		//Cost of meal
		System.out.println("Enter cost of meal: ");
		double mealCost = sc.nextDouble();
		
		double tipAmount = (mealCost * 1.15 - mealCost);
		System.out.println("15%");
		System.out.println("Tip Amount: " +tipAmount);
		
		double totalAmount = (mealCost * 1.15);
		System.out.println("Total Amount: " +totalAmount);
		
		
		
		double tipAmount2 = (mealCost * 1.20 - mealCost);
		System.out.println("20%");
		System.out.println("Tip Amount: " +tipAmount2);
		
		double totalAmount2 = (mealCost * 1.20);
		System.out.println("Total Amount: " +totalAmount2);
	
		
		double tipAmount25 = (mealCost * 1.25 - mealCost);
		System.out.println("25%");
		System.out.println("Tip Amount: " +tipAmount25);
		
		double totalAmount25 = (mealCost * 1.25);
		System.out.println("Total Amount: " +totalAmount25);
		
		
		
		
		System.out.println("Continue? y/n: ");
		choice = sc.next();
		System.out.println();
		
		}	
		
		System.out.println("Bye!");

	}

}
