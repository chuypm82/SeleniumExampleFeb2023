package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class ArrayListDS {
	
	public static void printList(List<String> words) {
		
		for(String word :  words) {
			System.out.println(word);
		}
		
		/*Iterator<String> iterator= words.iterator();
		
		while(iterator.hasNext()) {
			String word= iterator.next();
			System.out.println(word);
		}*/
		
		/*for(int i=0; i<words.size();i++) {
			System.out.println("Words ["+i+"]: " + words.get(i));
		}
		*/
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> words1 = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		
		int SIZE = 1000;		
		numbers.ensureCapacity(1000000);
		System.out.println("Number of WORDS1 capacity of elements before Adding Numbers is: " + numbers.size());
		
		for(int i=0; i<SIZE; i++) {
			numbers.add(i);
		}
		
		System.out.println("Number of WORDS1 capacity of elements before Trining is: " + numbers.size());
		words1.trimToSize();
		System.out.println("Number of WORDS1 capacity of elements after Triming is: " + numbers.size());
		
		words.add("school");
		words.add(0,"at");
		
		String w= words.get(0);
		
		System.out.println(words);
		
		words.set(1, "work");
		
		System.out.println(words);
		//words.remove(0);
		System.out.println(words);
		
		printList(words);
		

	}

}
