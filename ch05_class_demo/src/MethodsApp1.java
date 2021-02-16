import java.util.InputMismatchException;
import java.util.Scanner;

public class MethodsApp1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printWelcomeMessage();
		printWelcomeMessage("Bryan");
		System.out.println("55.7 / 6.2 = " + divide(55.7, 6.2));

		int n1 = getInt("Enter a whole number: ", sc);
		int n2 = getInt("Enter another whole number: ", sc);
		System.out.println("Sum of numbers [" + n1 + ", " + n2 + "] = " + (n1 + n2));
		
		double d1 = getDouble("Enter a decimal value: ", sc);
		System.out.println("Decimal entered: "+d1);
		
		// p. 165 NullPointerException
		String str = null;
		
		if (str.equalsIgnoreCase("hello")) {
			System.out.println("hello");
		}
		
		
		System.out.println("Bye!");
		sc.close();

	}

	// p. 153 - static method no parms and no return
	private static void printWelcomeMessage() {
		System.out.println("Welcome to the Methods App!!");
	}

	// static method with 1 parm and no returns
	private static void printWelcomeMessage(String name) {
		System.out.println("Welcome, " + name + ", to the Methods App!!");
	}

	// static method with 2 parms and a return
	private static double divide(double d1, double d2) {
		return d1 / d2;

	}

	// prompt user for a whole # and return that whole #
	// uses exception handling
	private static int getInt(String prompt, Scanner sc) {
		int nbr = 0;
		boolean isValid = false;
		while (!isValid) {
			try {
				System.out.print(prompt);
				nbr = sc.nextInt();
				isValid = true;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid Entry. Must be a whole number.");

				// clear input from scanner
				sc.nextLine();
			}
		}
		return nbr;

	}

	// prompt for a decimal number and return it... using data validation
	private static double getDouble(String prompt, Scanner sc) {
		double d = 0.0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			}

			else {
				System.out.println("Invalid Entry. Must be a decimal number.");
				sc.next();
			}
			
		}

		return d;
	}

}
