package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import business.Product;

public class CollectionDemoApp {

	public static void main(String[] args) {
		//p.389
		ArrayList<String> names = new ArrayList<>();
		names.add("Celina");
		names.add("Will");
		names.add("Lance");
		names.add("Daemon");
		names.add("Tom");
		names.add("Bryan");
		
		for (String s: names) {
			System.out.println(s);
		}
		System.out.println("print again...");
		names.add(3,"Sean");
		for (String s: names) {
			System.out.println(s);
		}
		
		System.out.println("name at index 1: "+names.get(1));
		
		System.out.println("names size = "+names.size());
		
		for(int i = 0; i <names.size(); i++) {
			System.out.println(i+names.get(i));
		}
	
		System.out.println("no loop, just print: "+names);
	
		//p.391
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(87);
		numbers.add(45);
		numbers.add(62);
		numbers.add(20);
		numbers.add(11);
		
		System.out.println("numbers.contains 62? "+numbers.contains(62));
		System.out.println(" 20 occurs at index "+numbers.indexOf(20));
		System.out.println(" 1 occurs at index "+numbers.indexOf(1));
		numbers.remove(new Integer(20));
		numbers.remove(1);
		System.out.println(numbers);
		numbers.set(1, 33);
		System.out.println(numbers);
		
		numbers.sort(null);
		System.out.println(numbers);
		
		//p.409 
		Product p1 = new Product("java", "Murach's Java Progamming", 59.50);
		Product p2 = new Product("andr", "Murach's Android Progamming", 57.50);
		Product p3 = new Product("net", "Murach's .Net Progamming", 58.50);
		
		Map<String, Product> productMap = new HashMap<>();
		productMap.put(p1.getCode(), p1);
		productMap.put(p2.getCode(), p2);
		productMap.put(p3.getCode(), p3);
		
		System.out.println(productMap.containsKey("andr"));
		System.out.println(productMap.containsKey("test"));
		System.out.println(productMap.containsValue(p2));
		System.out.println(productMap.get("andr"));

		//p.411 - print entries
		for (Map.Entry<String, Product> product: productMap.entrySet()) {
			System.out.println("Key: "+product.getKey()+", value: "+product.getValue());
		}
		
		
		
		
		
		
	}

}
