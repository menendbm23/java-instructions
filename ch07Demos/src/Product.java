// p.217
public class Product {
	//Sean's rules for creating a class:
	//1 Create the class
	//2 Create the instance variables
	//3 Generate constructor(s)
	//4 Generate getters/setters
	//5 Optional - Generate a toString()
	
	private String code;
	private String description;
	private double price;
	
	// 'fully loaded' constructor - not required, but a nice to have 
	public Product(String code, String description, double price) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}

	
