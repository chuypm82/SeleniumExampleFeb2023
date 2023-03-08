package JavaDataStructs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCompareDS {

	public static void main(String[] args) {

		// Initializing a list of type Linkedlist
        List<Integer> l = new LinkedList<>();
        l.add(10);
        l.add(15);
        l.add(20);
        System.out.println(l);
  
        // Initializing another list
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(10);
        l2.add(15);
        l2.add(20);
        System.out.println(l2);
  
        if (l.equals(l2))
            System.out.println("Equal");
        else
            System.out.println("Not equal");
    }
}
