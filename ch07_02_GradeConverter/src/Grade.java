
public class Grade {
	int number;

	public Grade() {
		number = 0;
		
	}
	public Grade(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getLetter() {
		String letter;
		if (number >= 88) {
			letter = "A";
	} else if (number >= 80) {
			letter = "B";
	} else if (number >= 67) {
			letter = "C";
	} else if (number >= 60) {
			letter = "D";
	} else {
			letter = "F";
	}
	return letter;
	}
	
	
}
