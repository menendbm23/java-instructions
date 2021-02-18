import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		Scanner sc = new Scanner(System.in);
		//start the dice rolling 
		
		System.out.print("Roll the dice? (y/n): ");
		String choice = sc.next();
		
		//continue until choice isn't equal to "y" or "Y"
		while (choice.equalsIgnoreCase("y")) {
			//create instance of Dice
			Dice dice = new Dice();
			//roll the dice
			dice.roll();
			//print the result
			System.out.println(dice.getRollResultString());
			//see if the user wants to continue
			System.out.print("Roll again (y/n)? ");
			choice = sc.next();
		}
		
		
		
		
		
		sc.close();
		System.out.println("Bye!");

	}

}
