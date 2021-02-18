import java.util.Scanner;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator \n");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
		
		String type = Console.getRequiredString("Calculate area of a circle, square, or rectangle? (c/s/r) : ");
		
		Shape shape = null;
		
		switch(type) {
			case "c":
				double radius = Console.getDouble("Enter radius: ", 0, Double.MAX_VALUE);
				shape = new Circle(radius);
				break;
			
			case "s":
				double width = Console.getDouble("Enter width: ", 0, Double.MAX_VALUE);
				shape = new Square(width);
				break;
				
			case "r":
				width = Console.getDouble("Enter width: ", 0, Double.MAX_VALUE);
				double length = Console.getDouble("Enter length: ", 0, Double.MAX_VALUE);
				shape = new Rectangle(width, length);
				break;
			
			default:
				System.out.println("Invalid shape entry.");
				break;
		}
		
		String shapeType = shape.getClass().getName();
		double area = shape.getArea();
		System.out.println("The area of the "+shapeType+" you entered is "+area);
		choice = Console.getChoiceString("Continue? (y/n): ", "y", "n");
	
		
		
		
		}
		
		System.out.println("Bye");

	}

}
