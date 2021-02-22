
public class UserIOTestApp {

	public static void main(String[] args) {
		UserIO c = IOFactory.getUserIO("console");
		
		c.println("Welcome to the Console Tester application");
		c.println();
		
		c.println("Int Test");
		int i = c.getInt("Enter an integer between -100 and 100: ", -101, 101);
		c.println
		
		c.println("Double Test");
		double d = c.getDouble("Enter any number between -100 and 100: ", -101, 101);
		c.println();
		
		c.println("required STring Test");
		String s1 = c.getString("Enter your email address: ");
		c.println();
		
		c.println("String choice Test");
		String s2 = c.getString("Select one (x/y): ", "x", "y");
	}
	
}