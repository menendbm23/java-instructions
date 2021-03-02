

public class RoshamboApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the game of Roshambo\n");
		
		String name = Console.getString("Enter your name: ");
		System.out.println();
		
		Player1 player1 = new Player1();
		player1.setName(name);
		
		String opponent = Console.getString(
				"Would you like to play Bart or Lisa? (B?L): ", "b", "l");
		System.out.println();

		Player player2 = null;
		if (opponent.equalsIgnoreCase("b")) {
			player2 = new Bart();
		} else if (opponent.equalsIgnoreCase("l")) {
			player2 = new Lisa();
		}
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String selection = Console.getString(
					"Rock, paper, or scissors? (R/P/S): ", "r", "p", "s");
			System.out.println();
			
			if (selection.equals("r")) {
				player1.setRoshambo(Roshambo.Rock);
			} else if (selection.equals("p")) {
				player1.setRoshambo(Roshambo.Paper);
			} else if (selection.equals("s")) {
				player1.setRoshambo(Roshambo.Scissors);
			}
			
			Roshambo rsb = player2.generateRoshambo(); 
			player2.setRoshambo(rsb);
			
			System.out.println(player1.getName() + ": " + player1.getRoshambo());
			System.out.println(player2.getName() + ": " + player2.getRoshambo());
			
			play(player1, player2);
			System.out.println();
			
			choice = Console.getString("Play again? (y/n): ", "y", "n");
			System.out.println();

		}
	}
	
	private static void play(Player player1, Player player2) {
		if (player1.getRoshambo() == player2.getRoshambo()) {
			System.out.println("Draw!");
		} else {
			if (
				(player1.getRoshambo() == Roshambo.Rock &&
				player2.getRoshambo() == Roshambo.Scissors) ||
				
				(player1.getRoshambo() == Roshambo.Paper &&
				player2.getRoshambo() == Roshambo.Rock) ||
				
				(player1.getRoshambo() == Roshambo.Scissors &&
				player2.getRoshambo() == Roshambo.Paper)
			) {
				System.out.println(player1.getName() + " wins!");
			} else {
				System.out.println(player2.getName() + " wins!");
			}
		}
	}

}
