import java.util.Scanner;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		//get data from the user and create appropriate object based on user choice
		String type = Console.getString("Create customer or employee? (c/e): ");
		String firstName = Console.getString("First Name: ");
		String lastName = Console.getString("Last name: ");
		
		
		if (type.equals("c")) {
				String customerNumber = Console.getString("Customer number: ");
					System.out.println("You entered a new Customer: ");
					System.out.println("Name: "+firstName +" "+lastName);
					System.out.println(("Customer Number: "+customerNumber+ "\n"));
					
					
	}	else if (type.equals("e")) {
				String ssn = Console.getString("SSN: ");
				System.out.println("You entered a new Employee: ");
				System.out.println("Name: "+firstName +" "+lastName);
				System.out.println("SSN: "+ssn+ "\n");
			}
			
		choice = Console.getString("Contine? (y/n): ");
		System.out.println();
			
		}
		
		
	
}

}



		
		

	


