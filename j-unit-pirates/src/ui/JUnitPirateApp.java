package ui;

import java.util.ArrayList;
import java.util.List;

import business.Pirate;

public class JUnitPirateApp {
	private static List<Pirate> pirates = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to JUnit Pirates!!!");
		pirates.add(new Pirate("Jack Sparrow"));
		pirates.add(new Pirate("Pegleg Pete", 3));
		pirates.add(new Pirate("Blackbeard"));
		pirates.add(new Pirate("Flying Dutchman"));
		
		printPirateStats();
		
		System.out.println("Pirate Fight!!!");		
		// 10 limbs will be lost in this fight		
		for (int i = 0; i < 10; i++) {			
			// generate a random index of the pirates array			
			int ridx = (int)(Math.random() * pirates.size());			
			pirates.get(ridx).loseALimb();		
			
		}
		
		printPirateStats();
		
		System.out.println("Bye!");

	}
	private static void printPirateStats() {
		System.out.println("Pirate stats:");
		for (Pirate p: pirates) {
			System.out.println(p);
		}
		System.out.println("Total Pirates: "+Pirate.getNumPirates());
		System.out.println("Total Limbs Lost: "+Pirate.getTotalLimbsLost());	
	}

}
