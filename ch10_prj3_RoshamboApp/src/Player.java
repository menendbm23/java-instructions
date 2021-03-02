
public abstract class Player {
	private String name;
	private Roshambo rsb;
	
	public Player() {
		name = "";
	}
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roshambo getRoshambo() {
		return rsb;
	}

	public void setRoshambo(Roshambo rsb) {
		this.rsb = rsb;
	}
	
	public abstract Roshambo generateRoshambo();
	
	
}
