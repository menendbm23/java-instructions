
public interface UserInput {
	public int getInt(String prompt);
	public int getInt(String prompt, int min, int max);
	
	public double getDouble(String prompt);
	public double getDouble(String prompt, double min, double max);
	
	public String getString(String prompt);
	public String getString(String prompt, String s1, String s2);
}
