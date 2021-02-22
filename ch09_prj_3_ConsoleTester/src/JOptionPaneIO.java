import.javax.swing.JOptionPane;

public class JOptionPaneIO implements UserIO {
	String message = "";
	
	public JOPtionPaneIO() { }

	@Override
    public void print(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    @Override
    public void println(){
        // a blank implementation for this method
    }
    @Override
    public void println(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    
    // implement UserInput interface
    @Override
    public int getInt(String prompt){
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            String s = this.getString(prompt);
            try {
                i = Integer.parseInt(s);
                isValid = true;
            } catch(NumberFormatException nfe) {
                println("Error! Invalid integer value. Try again.");
            }
        }
        return i;
    }
    @Override
    public int getInt(String prompt, int min, int max){
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = this.getInt(prompt);
            if (i <= min) {
                println("Error! Number must be greater than " + min);
            } else if (i >= max) {
                println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    @Override
    public double getDouble(String prompt){
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            String s = this.getString(prompt);
            try {
                d = Double.parseDouble(s);
                isValid = true;
            } catch(NumberFormatException nfe) {
                println("Error! Invalid decimal value. Try again.");
            }
        }
        return d;
    }
    @Override
    public double getDouble(String prompt, double min, double max){
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = this.getDouble(prompt);
            if (d <= min) {
                println("Error! Number must be greater than " + min);
            } else if (d >= max) {
                println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }

    @Override
    public String getString(String prompt){
        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            s = JOptionPane.showInputDialog(prompt);
            if (s == null || s.equals("")) {
                println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
    @Override
    public String getString(String prompt, String s1, String s2){
        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            s = this.getString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                println("Error! Entry must be '" + s1 +"' or '"+ s2 +"'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
}
