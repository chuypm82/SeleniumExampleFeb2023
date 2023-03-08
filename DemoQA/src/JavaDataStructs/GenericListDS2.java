package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class GenericListDS2 {

	public static <T> void printList(List<T> numbers) {
		for (T n : numbers) {
			System.out.println(n);
		}
	}
	
	public static void printSquare(List<? extends Number> numbers) {
	    for (Number n : numbers) {
	        double d = n.doubleValue();
	        System.out.println(d * d);
	    }
	}

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);

		//printList(ints);
		printSquare(ints);
	}
}
