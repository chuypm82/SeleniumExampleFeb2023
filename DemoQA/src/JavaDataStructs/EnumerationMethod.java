package JavaDataStructs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

public class EnumerationMethod {

	public static void main(String[] args) {

		try {

			// creating object of List<String>
			List<String> arrlist = new ArrayList<String>();

			// Adding element to srclst
			arrlist.add("Ram");
			arrlist.add("Gopal");
			arrlist.add("Verma");

			// Print the list
			System.out.println("List: " + arrlist);

			// creating object of type Enumeration<String>
			Enumeration<String> e = Collections.enumeration(arrlist);

			// Print the Enumeration
			System.out.println("\nEnumeration over list: ");

			// print the enumeration
			while (e.hasMoreElements())
				System.out.println("Value is: " + e.nextElement());
		}

		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown : " + e);
		}

		catch (NoSuchElementException e) {
			System.out.println("Exception thrown : " + e);
		}
	}
}
