package business;

import util.Console;

public class MovieListApp {

	public static void main(String[] args) {
		System.out.println("The Movie List application \n");
		System.out.println("Choose from 100 movies");
		System.out.println("Categories: drama | musical | scifi | horror | comedy| animated \n");
		
		String category = Console.getString("Enter a category: ");
		
		switch (category) {
			case "drama":
					System.out.println();
					break;
			case "musical":
					System.out.println();
					break;
			case "scifi":
					System.out.println();
					break;
			case "horror":
					System.out.println();
					break;
			case "comedy":
					System.out.println();
					break;
			case "animated":
					System.out.println();
					break;
			}
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) { 
			
			
			}
		



		
	
		
		
		System.out.println("Bye!");

	}

}
