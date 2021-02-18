
public class Die {

	private int value;

	public Die() {
		value = 0;
	}

	//this constructor wont be used, just for demo purposes 
	public Die(int v) {
		super();
		value = v;
	}

	public int getValue() {
		return value;
	} 
	
	//set value of die 
	public void roll() {
		value = (int)(Math.random()*6)+1;
	}
	
}
