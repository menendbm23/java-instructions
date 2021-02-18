
public class Dice {
	private Die die1;
	private Die die2;
	
	public Dice() {
		super();
		die1 = new Die();
		die2 = new Die();
	}

	public Die getDie1() {
		return die1;
	}

	public void setDie1(Die die1) {
		this.die1 = die1;
	}

	public Die getDie2() {
		return die2;
	}

	public void setDie2(Die die2) {
		this.die2 = die2;
	}
	
	public int getSum() {
		return die1.getValue() + die2.getValue();
	}
	
	public void roll() {
		die1.roll();
		die2.roll();
	}
	
	public String getRollResultString() {
		String result = "Die 1:\t"+getDie1().getValue() + "\n" +
						"Die 2:\t"+getDie2().getValue() + "\n" +
						"Total:\t"+getSum() + "\n";
		if (getSum()==2) {
			result += "Snake Eyes!\n";
		}
		else if (getSum()==7) {
			result += "Craps!\n";
		}
		else if (getSum()==12) {
			result += "Box Cars!\n";
		}
		return result;
	}
	
	
	
	
	
	
	
	
}
