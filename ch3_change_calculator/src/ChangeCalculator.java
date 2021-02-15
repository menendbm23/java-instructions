import java.util.Scanner;

public class ChangeCalculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the Change Calculator!");
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		while (choice.equalsIgnoreCase("y")) {

			System.out.println("Enter number of cents between 0 and 99");
			int number = sc.nextInt();
	
		
		int numberOfQuarters = (int)(number/25);
	    int changeRemaining = number %25;
	    
	    
	    System.out.println("Quarters: " + numberOfQuarters);
	    System.out.println("Change Remaining: " + changeRemaining);
	    

	    int numberOfDimes = (int)(changeRemaining/10);
	    changeRemaining = number %10;
	   
	    
	    System.out.println("Dimes: " + numberOfDimes);
	    System.out.println("Change Remaining: " + changeRemaining);
	    
	    int numberOfNickles = (int)(changeRemaining/5);
	    changeRemaining = number %5;
	    
	    
	    System.out.println("Nickles: " + numberOfNickles);
	    System.out.println("Change Remaining: " + changeRemaining);
	    
	    int numberOfPennies = (int)(changeRemaining/1);
	    changeRemaining = number %1;
	    
	    
	    System.out.println("Pennies: " + numberOfPennies);
	    System.out.println("Change Remaining: " + changeRemaining);
	    
		
		System.out.print("Do you want to continue (y/n)? ");
		choice = sc.next();
		if (choice.equals("y")) {
		}
		else if (choice.equals("n")) {
			System.out.println("Bye!");
			sc.close();
		}
		}
	}

}

