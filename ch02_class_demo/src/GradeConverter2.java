import java.util.Scanner;

public class GradeConverter2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grade Converter! ");
		String choice = "y";
		int testScore = 0;
		Scanner sc = new Scanner(System.in);
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Please enter test score!");
			// get input from the user
			testScore = sc.nextInt();
			if ((testScore >= 88) & (testScore <= 100)) {
				System.out.println("A");

			} else if ((testScore >= 80) & (testScore <= 87)) {
				System.out.println("B");

			} else if ((testScore >= 67) & (testScore <= 79)) {
				System.out.println("C");

			} else if ((testScore >= 60) & (testScore <= 66)) {
				System.out.println("D");

			} else if ((testScore >= 0) & (testScore <= 59))
				System.out.println("F");

			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			
		}
		System.out.println("Bye!");
	}

}
