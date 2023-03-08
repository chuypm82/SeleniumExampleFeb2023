package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class GenericsIssueListDS2 {
	
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);

		// mistakenly
		//numbers.add("test");//  =======>Compilation issue

		// read the numbers
		// read the numbers
		for (int i = 0; i < numbers.size(); i++) {
			try {
				Integer n = (Integer) numbers.get(i);
				// do something with n
			} catch (ClassCastException e) {
				System.out.println("Unexcepted type " + e.getMessage());
			}
		}
	}
	
}
