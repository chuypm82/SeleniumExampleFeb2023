package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class GenericWithError5 {
	
	public static <T> void printSquare(List<T> numbers) {
	    for (T n : numbers) {
	        double d = ((Integer) n).doubleValue();
	        System.out.println(d * d);
	    }
	}

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<Integer>();
	    ints.add(1);
	    ints.add(2);
	    ints.add(3);
	    printSquare(ints);
	}
}