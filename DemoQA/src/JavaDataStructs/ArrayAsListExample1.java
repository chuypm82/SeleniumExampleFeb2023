package JavaDataStructs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample1 {

	public static void main(String[] args) {

		String a[] = new String[] { "A", "B", "C", "D" };

		// Getting the list view of Array
		List<String> list = Arrays.asList(a);
		
		Integer[] arrayNum= {1,2,3,4,5};
		List<Integer> lisNum= new ArrayList<Integer>();
		
		System.out.println("The list is: " + lisNum);
		lisNum= Arrays.asList(arrayNum);

		// Printing all the elements in list object
		System.out.println("The list is: " + lisNum);

	}
}
