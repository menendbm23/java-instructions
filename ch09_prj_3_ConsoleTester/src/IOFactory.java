
public class IOFactory {
	public static UserIO getUserIO(String type) {
		switch (type) {
		case "console":
			return new ConsoleIO();
		case "option":
			return new JOptionPaneIO();
		default:
			return null;
		}
	}

}
