
public class VariablesApp {

	public static void main(String[] args) {
		System.out.println("Hello from Variables App!!!");
		
		int quantity; 
		quantity = 0;
		
		quantity = quantity +1; 
		// compound assignment operator 
		quantity += 1;
		// unary operator 
		quantity ++;
		
		double price = 57.99;
		// increase price by 10%
		price *= 1.1; 
		
		System.out.println("Quantity = "+quantity);
		System.out.println("Price = "+price);
		
		System.out.println("Bye!");

	}

}
