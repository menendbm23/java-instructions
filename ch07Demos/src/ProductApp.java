
public class ProductApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		//p. 221 to 225 creating instances of Product, accessing
		Product product1 = new Product("java", "Murach's Java Programming",59.50);
		
		System.out.println("product1 = "+product1.getCode()+", "+product1.getDescription()+", "+
							product1.getPrice());
		product1.setCode("test");
		System.out.println(product1);
		product1.setCode("java");
		System.out.println(product1);
		System.out.println("desc = "+product1.getDescription());
		//System.out.println("Product desc = "+product.getDescription()); <=cannot static call getters>
		
		//create a vendor
		Vendor vendor1 = new Vendor(); //Java gives you a default constructor by default
		// Java's default constructor goes away if you generate any other constructor 
		
		String code = Console.getString("Product Code: ");
		String desc = Console.getString("Product Desc: ");
		double price = Console.getDouble("Product Price: ");
		
		Product product2 = new Product(code, desc, price);
		
		System.out.println("Product 2 = "+product2);
		
		
		
		System.out.println("Bye");

	}

}
