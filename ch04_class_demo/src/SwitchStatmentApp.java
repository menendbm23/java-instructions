import java.util.Scanner;

public class SwitchStatmentApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Switch Statement Demo");

		Scanner sc = new Scanner(System.in);
		String direction = "";

		while (!direction.equalsIgnoreCase("x")) {

			// p. 129
			System.out.println("You've come to an intersection. which way do you want to go?");
			System.out.println("N - North");
			System.out.println("S - South");
			System.out.println("E - East");
			System.out.println("W - West");
			System.out.println("X - Exit");
			direction = sc.next();
			
			switch (direction) {
			case "N":
			case "n":
				System.out.println("North..... a yeti appears!!!");
				break;
			case "S":
			case "s":
				System.out.println("South..... a dragon appears!!!");
				break;
			case "E":
			case "e":
				System.out.println("East..... a tidal wave is coming!!!");
				break;
			case "W":
			case "w":
				System.out.println("West..... forest fires!!!");
				break;
			case "X":
				// do nothing, code will exit 
				break;
				
			}
		}

		System.out.println("Bye");

	}

}
