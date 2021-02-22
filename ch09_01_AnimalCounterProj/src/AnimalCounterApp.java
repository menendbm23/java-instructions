
public class AnimalCounterApp {

	
	public static void main(String args[]) {
		countAlligators();
		countSheep();
		
	}
	public static void countAlligators() {
		System.out.println("Counting alligators...\n");
		
		Alligator gator = new Alligator();
		
		count(gator, 3);
	}
	public static void countSheep() {
		System.out.println("Counting sheep...\n");
		
		Sheep blackie = new Sheep();
		blackie.setName("Blackie");
		
		count(blackie, 2);
		
		Sheep dolly = null;
		try {
			dolly = (Sheep) blackie.clone();
			dolly.setName("Dolly");
			count(dolly, 3);
		} catch(CloneNotSupportedException e) {
			System.out.println("Unable to clone: " + e.getMessage());
		}
		
		count(blackie, 1);
	}
	public static void count(Countable c, int maxCount) {
		c.resetCount();
		while (c.getCount() <= maxCount) {
			System.out.println(c.getCountString());
			c.incrementCount();
		}
		System.out.println();
	}
	
	
}
