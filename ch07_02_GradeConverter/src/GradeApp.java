
public class GradeApp {

	public static void main(String[] args) {
		//display a welcome message
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println(); //print a blank line 
		
		//perform conversions until choice isn't equal to "y" or "Y"
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//get numerical grade from user 
			int number = Console.getInt("Enter numerical grade: ");
			Grade grade = new Grade(number);
			
			//display the result of the conversion
			System.out.println("Letter grade: " + grade.getLetter() + "\n");
			
			//see if user wants to continue
			choice = Console.getString("Continue? (y/n): ", "y", "n");
			System.out.println();
		}
		

	}

}
