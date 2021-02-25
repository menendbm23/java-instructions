package business;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryApp {
	//initialize list of items: ArrayList<String>
	//defining items as a 'List' demonstrates polymorphism!!!
	static List<String> items = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		// put 3 starting items in items
		items.add("wooden staff");
		items.add("wizard hat");
		items.add("cloth shoes");
		
		String command = "";
		
		//while loop start
		while (!command.equalsIgnoreCase("exit")) {
			
			// display command menu
		System.out.println("The Wizard Inventory Game \n");
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program \n");
		System.out.println();
			
		
			// prompt user for command
		command = Console.getRequiredString("COMMAND: ");
		
		
			// determine the command to perform
		switch (command) {
		case "show":
			//show = show all items - loop through 'items' and display each 
				// NOTE: item # is not the index #, its index + 1
			 for (int i = 0; i < items.size(); i++) {
				 System.out.println((i+1)+". "+items.get(i));
			 }
			break;
		case "grab":
			//check # of items. max is 4 
			if (items.size()>=4) {
				System.out.println("Max items reached. Drop an item before adding.");
			}
			else {
				// grab - grab an item (add new item to 'items')
					// Prompt user for new item name and add to 'items'
				String name = Console.getRequiredString("Name: ");
				items.add(name);
				System.out.println(name+ " was added.");
			}
			break;
		case "edit":
			//edit - change the name of an item 
				// prompt user for item #, validate that item #
			int itemNbr = Console.getInt("Number: ", 0, (items.size()+1));
				// prompt user for updated name, save that in the list 
			if (validateItemNumber(itemNbr)) {
				String updName = Console.getRequiredString("Update name: ");
				items.set((itemNbr-1), updName);
				System.out.println("Item "+itemNbr+" was udpated.");
				// "Item x was updated"
			}
			else {
				System.out.println("Item nbr not valid.");
			}
			break;
		case "drop":
			//drop - drop an item (remove from 'items')
				// prompt user for item #, validate that item #
			itemNbr = Console.getInt("Number: ", 0, (items.size()+1));
			if (validateItemNumber(itemNbr)) {
				// remove item from list and capture item name 
				// "'item name' was dropped"
				String droppedItem = items.remove(itemNbr-1);
				System.out.println(droppedItem+" was dropped.");
			}
			else {
				System.out.println("Item nbr not valid.");
			}
			break;
		case "exit":
			// exit - exit the app
			break;
		default:
			System.out.println("Invalid command, try again.");
			break;
		}
		
	}
		
	System.out.println("Bye");
	

	}
	
	// because our item numbers start at zero the index will always be 1 less than item number
	private static boolean validateItemNumber(int itemNbr) {
		return (items.get(itemNbr - 1) != null);
	}

}
