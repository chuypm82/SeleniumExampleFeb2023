package JavaDataStructs;

import java.util.Hashtable;

class ContactBook {
	Hashtable<String, String> contacts;
	
	ContactBook(){
		contacts = new Hashtable<String, String>();
	}
	
	public boolean hasEmailAddress(String emailAddress) {
		return contacts.containsValue(emailAddress);
	}
	
	public boolean hasName(String name) {
		return contacts.containsKey(name);
	}
	
	public int addContact(String name, String emailAddress) {
		if(hasEmailAddress(emailAddress)){
			System.out.println("Cannot add ["+name+"] Emal adress ["+emailAddress+"] existed" );
			return 0;
		}
		else if(hasName(name)) {
			System.out.println("Name ["+name+"] existed");
			return 0;
		}else {
			contacts.put(name, emailAddress);
			System.out.println("A new contact for ["+name+"] added");
			return 1;
		}
	}
	
	public int deleteContact(String name) {
		if(hasName(name)) {
			contacts.remove(name);
			System.out.println("Contact for ["+name+"] removed");
			return 1;
		}else {
			System.out.println("Contact for ["+name+"] not found");
			return 0;
		}
	}
	
	public String findEmailAddress(String name) {
		String emailAddress = contacts.get(name);
		if(emailAddress != null) {
			System.out.println("["+name+"]: ["+emailAddress+"]");
			return emailAddress;
		}else {
			System.out.println("Contact for ["+name+"] not found");
			return null;
		}
	}
	
	public void listAllContacts() {
		System.out.println("\n> Current contact list \n");
		System.out.printf("%-10s|%-20s \n", "Name", "Email Address");
		for(String name : contacts.keySet()) {
			String emailAddress= contacts.get(name);
			System.out.printf("%-10s|%-20s \n", name, emailAddress);
		}
	}


}

public class HashTableDS {

	public static void main(String[] args) {
		ContactBook book= new ContactBook();
		
		System.out.println("> Add Contacts\n");
		book.addContact("Alice", "alice@example.com");
		book.addContact("Bob", "bob@example.com");
		book.addContact("Catrhine", "cathrine@example.com");
		book.addContact("Jane", "cathrine@example.com");
		book.addContact("Alice", "alice1@example.com");
		
		System.out.println("\n> Find Contact\n");
		book.findEmailAddress("Alice");
		book.findEmailAddress("Jane");
		book.listAllContacts();
		
		System.out.println("\n> Remove contact\n");
		book.deleteContact("Alice");
		book.listAllContacts();

	}

}
