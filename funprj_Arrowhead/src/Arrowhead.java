import util.Console;

public class Arrowhead {

	public static void main(String[] args) {
		System.out.println("Welcome to the Arrowhead challenge");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//top half of arrowhead
			//outer for loop = rows
		
			int size = Console.getInt("Provide the size of an arrowhead: ", 0, Integer.MAX_VALUE);
			int midpoint = size/2 + 1;
			
			for (int i=0; i <= midpoint; i++) {
				// build each row, c refers to characters per line
				String row = "";
				//building the line
				for (int c=1; c<=i; c++) {
					row +=">";
				}
				System.out.println(row);
			}
			
			//bottom half of arrowhead
			//midpoint line already printed 
			for (int i=(midpoint-1); i > 0; i--) {
				String row = "";
				for (int c = 1; c <= i; c++) {
					row += ">";
				}
				System.out.println(row);
			}
			choice = Console.getString("Continue? (y/n): ");
		
		}
		
		System.out.println("Bye");

	}

}
