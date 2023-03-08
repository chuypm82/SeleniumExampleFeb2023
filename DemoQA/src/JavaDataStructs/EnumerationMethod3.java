package JavaDataStructs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

public class EnumerationMethod3 {

	public static void main(String[] args) {

		// creating object of List<String>
		List<Integer> arrlist = new ArrayList<Integer>();

		// Adding element to srclst
		arrlist.add(20);
		arrlist.add(30);
		arrlist.add(40);

		// Print the list
		System.out.println("List: " + arrlist);

		// creating object of type Enumeration<String>
		Enumeration<Integer> e = Collections.enumeration(arrlist);

		// Print the Enumeration
		System.out.println("\nEnumeration over list: ");

		// print the enumeration
		while (e.hasMoreElements())
			System.out.println("Value is: " + e.nextElement());

	}
}
