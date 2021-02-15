
public class StringsApp {

	public static void main(String[] args) {
		System.out.println("Hello Strings");
		
		String firstName = "Bob"; 
		System.out.println(firstName);
		String lastName = "Marley";
		
		System.out.println(firstName + " " + lastName);
		
		String fullName = firstName + " " + lastName; 
		System.out.println(fullName);
		
		fullName = "Sarah"; 
		
		fullName += " Connor";
		System.out.println(fullName.toString());
		
		// p. 48 reference types vs primitive 
		int n = 5;
		
		// system.out.println(n.); <-- cant do this...int not a type!!
		
		// concat a String and a primitive 
		fullName += 5;
		System.out.println(fullName);
		
		// p.51 escape sequences
		String msg = "This is going to be\t a really, really \nreally really long message!!!";
				System.out.println(msg);
	
		
				
		System.out.println("Bye");

	}

}
