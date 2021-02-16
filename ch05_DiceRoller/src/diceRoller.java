import java.util.Scanner;

public class diceRoller {

	
	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		System.out.println("Roll the dice? (y/n): ");
			Scanner sc = new Scanner(System.in);
				String choice = "y";
				
				choice = sc.next();
				while (choice.equalsIgnoreCase("y")) {
					
					
	
		
		int die1 = (int)(Math.random() * 6) +1;
		int die2 = (int)(Math.random() * 6) +1;
		
		System.out.println("Die 1: "+die1);
		System.out.println("Die 2: "+die2);
		System.out.println("Total: "+(die1 + die2));
		System.out.println();
	
		if (die1 == 1 && die2 == 1) {
			System.out.println("Snake Eyes!");
		} else if (die1 == 6 && die2 == 6) {
			System.out.println("Boxcars!!");
		}
		
		
		System.out.println("Roll again? (y/n): ");	
		choice = sc.next();
		
		
		
		}
		
				
		System.out.println("Bye!");
	}
	

}



