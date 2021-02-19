import java.util.Scanner;

public class Console {
	private Scanner sc;
	
public Console() {
	sc = new Scanner(System.in);
}

public String getString(String prompt) {
	System.out.println(prompt);
	return sc.nextLine();
}

public int getInt(String prompt) {
	int i = 0;
	boolean isValid = false;
	while (!isValid) {
		System.out.println(prompt);
		if (sc.hasNextInt()) {
			i = sc.nextInt();
			isValid = true;
		} else {
			System.out.println("Error! Invalid integer. Try again.");
		}
		sc.nextLine();
	}
	return i;
}

public double getDouble(String prompt) {
	double d = 0;
	boolean isValid = false;
	while (!isValid) {
		System.out.println(prompt);
		if (sc.hasNextDouble()) {
			d = sc.nextDouble();
			isValid = true;
		} else {
			System.out.println("Error! Invalid number. Try again.");
		}
		sc.nextLine();
	}
	return d;
	}
}