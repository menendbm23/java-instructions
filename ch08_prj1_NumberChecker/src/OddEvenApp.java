
public class OddEvenApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Odd/Even Checker!\n");
		
		// create the MyConsole object
		MyConsole console = new MyConsole();
		
		// perform conversions until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//get an int from the user 
			int num = console.getInt("Enter an integer: ");
			
			// determine whether the int is odd or even 
			String oddOrEven = "odd";
			if (num % 2 == 0) {
				oddOrEven = "even";
			}
		
			// display the result
			System.out.println("The number " + num + " is " + oddOrEven + ".\n");
			
			//see if the user wants to continue
			choice = console.getString("Continue? (y/n): ");
			System.out.println();
		
		}
		

	}

}
