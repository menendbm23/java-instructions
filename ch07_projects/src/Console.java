import java.util.Scanner;

public class Console {
	    
	    private static Scanner sc = new Scanner(System.in);

	    public static String getString(String prompt) {
	        System.out.print(prompt);
	        String s = sc.next();  // read user entry
	        sc.nextLine();  // discard any other data entered on the line
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
	                System.out.println("Error! Invalid. Try again.");
	            }
	            sc.nextLine();  // discard any other data entered on the line
	        }
	        return i;
	    }
	
	
	
}
