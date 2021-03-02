
public class Lisa extends Player {
	public Lisa() {
		super();
		super.setName("Lisa");
	}
	
	@Override
	public Roshambo generateRoshambo() {
		
		int i = (int) (Math.random() * 3);
		
		if (i == 0) {
			return Roshambo.Rock;
		} else if (i == 1) {
			return Roshambo.Paper;
		} else {
			return Roshambo.Scissors;
		}
	}

}
