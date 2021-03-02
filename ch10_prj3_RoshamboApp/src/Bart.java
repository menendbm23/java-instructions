
public class Bart extends Player {
	public Bart() {
		super();
		super.setName("Bart");
	}
	
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.Rock;
	}

}
