package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import business.Contact;
import business.TestContact;

public class ContactManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact Manager App!");
		//p. 703
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		System.out.println("All contacts");
		System.out.println("=============");
		displayContacts(contacts);
		
		System.out.println("Contacts w/ no phone");
		System.out.println("=====================");
		//displayContactsNoPhone(contacts);
		// filter list using lambda expression 
		List<Contact> contactsNoPhone = filterContacts(contacts, c -> c.getPhone()==null);
		displayContacts(contactsNoPhone);
		
		System.out.println("Contact w/no email");
		System.out.println("====================");
		//displayContactsNoEmail(contacts);
		List<Contact> contactsNoEmail = filterContacts(contacts, c -> c.getEmail()==null);
		displayContacts(contactsNoEmail);
		
		System.out.println("Contacts w/ no email or phone");
		System.out.println("==============================");
		//displayContactsNoEmailNorPhone(contacts);
		List<Contact> contactsNoEmailNorPhone = filterContacts(contacts, c -> 
				c.getPhone()==null && c.getEmail()==null);
		displayContacts(contactsNoEmailNorPhone);
		
		System.out.println("Use Consumer to print all contact names");
		System.out.println("=======================================");
		processContacts(contacts, c-> System.out.println(c.getName()));
		
		System.out.println("Use Function Interface to transform contact list");
		System.out.println("================================================");
		List<String> contactPhoneNumbers = transformContacts(contacts,
					c -> { 
						String phone = (c.getPhone()==null ? "na" : c.getPhone());
						return c.getName()+": "+phone;
		});
		
		//p. 717 - streams
		// use a stream to print list of strings
		contactPhoneNumbers.stream().forEach(s -> System.out.println(s));
		
		//equivalent
		for (String s: contactPhoneNumbers) {
			System.out.println(s);
		}
		
		
		
		System.out.println("Bye!");

	}
	
	// p.705 one method using functional interface, TestContact, to replace all the original methods
	//public static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
		//List<Contact> filteredContacts = new ArrayList<>();
		//for (Contact c: contacts) {
			//if (condition.test(c)) {
				//filteredContacts.add(c);
			//}
		//}
		
		//return filteredContacts;
	//}
	
	//p 709 using Predicate Interface 
	public static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
	}
	
	//p.711 using consumer interface
	public static void processContacts(List<Contact> contacts,
										Consumer<Contact> consumer) {
		for (Contact c: contacts) {
			consumer.accept(c);
			
		}
	}
	
	//p. 713 Function interface
	public static List<String> transformContacts(List<Contact> contacts,
												Function<Contact, String> function) {
		List<String> strings = new ArrayList<>();
		for (Contact c: contacts) {
			strings.add(function.apply(c));
		}
		return strings;
	}
	
	private static void displayContacts(List<Contact> contacts) {
		for (Contact c: contacts) {
			System.out.println(c);
		}
	}
	
	private static void displayContactsNoPhone(List<Contact> contacts) {
		for (Contact c: contacts) {
			if (c.getPhone()==null)
			System.out.println(c);
		}
	}

	private static void displayContactsNoEmail(List<Contact> contacts) {
		for (Contact c: contacts) {
			if (c.getEmail()==null)
			System.out.println(c);
		}
	}
	
	private static void displayContactsNoEmailNorPhone(List<Contact> contacts) {
		for (Contact c: contacts) {
			if (c.getEmail()==null && c.getPhone()==null)
			System.out.println(c);
		}
	}
	
}
