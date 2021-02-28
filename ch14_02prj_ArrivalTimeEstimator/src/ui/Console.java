package ui;


import java.time.LocalDate;
import java.util.Scanner;

public class Console {
    
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
    
    public static String getRequiredString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }

    public static String getChoiceString(String prompt,
            String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
    public static String getChoiceString(String prompt,
            String[] validEntries) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(prompt);
            // loop through all valid entries to see if user entry is valid
            for (String str: validEntries) {
	            if (s.equalsIgnoreCase(str)) {
	            	isValid = true;
	            	break;
	            }
            }
            // if user did not match then display an error
            if (!isValid)
            	System.out.println("Invalid entry, '"+s+"'. Try again.");
        }
        return s;
    }


    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid number. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }
    
    public static boolean getBoolean(String prompt, String valTrue, String valFalse) {
        boolean retBoolean = false;
        boolean isValid = false;
        String s = "";
        while (!isValid) {
            s = getRequiredString(prompt);
            if (!s.equalsIgnoreCase(valTrue) && !s.equalsIgnoreCase(valFalse)) {
                System.out.println("Error! Entry must be '" + valTrue + "' or '" + valFalse + "'. Try again.");
            } else {
                isValid = true;
                // entry is valid... now return true or false (default)
                if (s.equalsIgnoreCase(valTrue)) {
                	retBoolean = true;
                }
            }
        }
        return retBoolean;

    }
    
    // This method will print the prompt then follow with "Enter month... day... year" prompts
    // Note:  will need enhancement to manage leap year
    public static LocalDate getLocalDate(String prompt) {
    	LocalDate ld = null;
    	boolean isValid = false;
    	while (!isValid) {
	    	System.out.println(prompt);
	   		int month = getInt("Enter month (1-12): " , 0, 13);
	   		int day = getInt("Enter day of month (1-31): " , 0, 32);
	   		int year = getInt("Enter year (> 0): " , 0, Integer.MAX_VALUE);
	    	try {
	    		ld = LocalDate.of(year, month, day);
	    		isValid = true;
	    	}
	    	catch (Exception e) {
	    		System.out.println("Error constructing date from entries.  Try again.");
	    	}
    	}
    	return ld;
    }
}