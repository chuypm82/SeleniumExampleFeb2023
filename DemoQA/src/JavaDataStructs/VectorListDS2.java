package JavaDataStructs;

import java.util.List;
import java.util.Vector;

public class VectorListDS2 {
	
	public static void printList(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            System.out.println("Words[" + i + "]: " + words.get(i));
        }
	}

	public static void main(String[] args) {
		
		List<String> words = new Vector<String>();
        // append
        words.add("school");
        printList(words);

        words.add(0, "at");
        System.out.println("> Insert via index");
        printList(words);

        words.set(1, "work");
        System.out.println("> Update via index");
        printList(words);

        words.remove(0);
        System.out.println("> Remove via index");
        printList(words);
        
	}
}
