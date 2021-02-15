import java.util.Scanner;

public class schoolRegistration {

	public static void main(String[] args) {
		// display welcome message student registration
		System.out.println("Student Registration Form. Please enter your name!");
		Scanner sc = new Scanner(System.in);
		
		// get input from the user 
		String name = sc.next();
		String name2 = sc.next();
		System.out.println("Thank you! Please enter your date of birth!");
		
		
		String year = sc.next();
		System.out.println("Welcome "+name +" " +name2);
		System.out.println("Your registration is complete");
		System.out.println("You're temporary password is "+name +"*" +year);
		
		
		
		
	}

	}




