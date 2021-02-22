import java.util.Scanner;

public class ConsoleIO implements UserIO {
    private Scanner sc;
    
    public ConsoleIO() {
        sc = new Scanner(System.in);
    }
    
    // implement UserOutput interface
    @Override
    public void print(String s) {
        System.out.print(s);
    }
    @Override
    public void println() {
        System.out.println();
    }
    @Override
    public void println(String s) {
        System.out.println(s);
    }
    
    // implement UserInput interface
    @Override
    public int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                println("Error! Invalid integer. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return i;
    }
    @Override
    public int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = this.getInt(prompt);
            if (i <= min) {
                println("Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                println("Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    @Override
    public double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                println("Error! Invalid number. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return d;
    }
    @Override
    public double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = this.getDouble(prompt);
            if (d <= min) {
                println("Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                println("Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }

    @Override
    public String getString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
    @Override
    public String getString(String prompt, String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = this.getString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                println("Error! Entry must be '" + s1 + "' or '" + s2 +
                        "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
}
