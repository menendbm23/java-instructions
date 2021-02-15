import java.util.Scanner;

public class GradeConverterClassDemo {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grade Converter! Please enter a test score between 1-100.");
		Scanner sc = new Scanner(System.in);
		
		// perform conversions until choice isn't equal to "y"  or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			//get numerical grade from user
			System.out.println("Enter Numerical Grade: ");
			int numericalGrade = sc.nextInt();
			
			//convert numerical grade to letter grade
			String letterGrade = "";
			if (numericalGrade >= 88) 
				letterGrade = "A";
			else if (numericalGrade >= 80)
				letterGrade = "B";
			else if (numericalGrade >= 67)
				letterGrade = "C";
			else if (numericalGrade >= 60)
				letterGrade = "D";
			else
				letterGrade = "F";
			
			//display the result of conversion 
			System.out.println("Letter grade: " + letterGrade + "\n");
			
			//see if the user wants to continue
			
			}
		}

	}


