package ui;

public class PigLatinApp {

	public static void main(String[] args) {
		System.out.println("Pig Latin Translator\n");
		String another = "y";
		while (another.equalsIgnoreCase("y")) {
			
			//get input
		String input = Console.getString("Enter a line: ");
		if (input.isEmpty()) {
			System.out.println("You didn't enter any text. Please try again.\n");
			continue;
		}
		
		// process input and display output
		String [] words = input.split(" ");
		String pigLatin = "";
		for (String word : words) {
			pigLatin += translateWord(word.toLowerCase()) + " ";
		}
		System.out.println(pigLatin + "\n");
		
		//another line?
		another = Console.getString("Another line? (y/n): ");
				System.out.println();
		}
		System.out.println("Bye");
	}
	
	public static String translateWord(String word) {
		//remove punction from end of word
		if (word.endsWith(".") ||
			word.endsWith(",") ||
			word.endsWith("!") ||
			word.endsWith(";")) {
			word = word.substring(0, word.length()-1);
		}
		
		//remove word if it contains symbols or numbers
		if (word.contains("@") ||
	            word.contains("#") ||
	            word.contains("$") ||
	            word.contains("1") ||
	            word.contains("2") ||
	            word.contains("3") ||
	            word.contains("4") ||
	            word.contains("5") ||
	            word.contains("6") ||
	            word.contains("7") ||
	            word.contains("8") ||
	            word.contains("9")) {
	            return word;
		}
		
		//translate word
		char c = word.charAt(0);
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			word += "way";
		} else {
			if (c == 'y') {
				word = word.substring(1);
				word += c;
				c = word.charAt(0);
			}
			while (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
				word = word.substring(1);
				word += c;
				c = word.charAt(0);
			}
			word += "ay";
		}
		return word;
	}

}
