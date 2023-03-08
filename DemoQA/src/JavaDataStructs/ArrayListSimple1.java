package JavaDataStructs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSimple1 {

	public static void main(String[] args) {

		// Size of ArrayList
		int n = 5;

		// Declaring the List with initial size n
		//List<Integer> arrli = new ArrayList<Integer>(n);
		
		// Declaring the List without initial size n
		List<Integer> arrli = new ArrayList<Integer>();

		// Appending the new elements
		// at the end of the list
		for (int i = 1; i <= n; i++)
			arrli.add(i);

		// Printing elements
		System.out.println(arrli);

		// Remove element at index 3
		arrli.remove(3);

		// Displaying the list after deletion
		System.out.println(arrli);

		// Printing elements one by one
		for (int i = 0; i < arrli.size(); i++)
			System.out.print(arrli.get(i) + " ");
	

		arrli.add(2);
		arrli.add(4);
		
		System.out.println();
		// Printing elements one by one with advanced loop
		for(int num : arrli)
			System.out.print(num + " ");
		
		System.out.println();		
		arrli.stream().sorted().forEach(num->System.out.print(num + " "));
		
	/*	Collections.sort(arrli);
		
		System.out.println();
		// Printing elements one by one with advanced loop
		for(int num : arrli)
			System.out.print(num + " ");*/
		
	}
}
