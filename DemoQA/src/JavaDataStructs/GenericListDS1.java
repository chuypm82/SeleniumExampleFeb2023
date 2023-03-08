package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class GenericListDS1 {

	public static <T> void printList(List<T> elements) {
		for (T n : elements) {
			System.out.println(n);
		}
	}

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);

		printList(ints);
		
		List<String> strs = new ArrayList<String>();
		strs.add("String1");
		strs.add("String2");
		strs.add("String3");
		
		printList(strs);
	}
}
