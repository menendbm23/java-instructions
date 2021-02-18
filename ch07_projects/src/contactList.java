import java.util.Scanner;

public class contactList {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List application");
		Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
        	
        	
        	System.out.println("Enter first name: ");
        	String firstName = sc.next();
        	
        	System.out.println("Enter last name: ");
        	String lastName = sc.next();
        	
        	System.out.println("Enter email: ");
        	String email = sc.next();
        	
        	System.out.println("Enter phone: ");
        	String phone = sc.next();
        	
        	System.out.println("-------------------------------------------");
        	System.out.println("----Current Contact------------------------");
        	System.out.println("-------------------------------------------");
        	System.out.println("Name: "+firstName + " " +lastName);
        	System.out.println("Email Address: "+email);
        	System.out.println("Phone Number: "+phone);
        	System.out.println("-------------------------------------------");
        	
        	
        	System.out.print("Continue? (y/n): ");
            choice = sc.next();
            sc.nextLine();  
            System.out.println();
        }
		
		
		
      System.out.println("Bye!");

	}

}
