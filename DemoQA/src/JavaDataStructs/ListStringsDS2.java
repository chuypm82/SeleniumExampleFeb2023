package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class ListStringsDS2 {

	public static void main(String[] args) {

		 // Creating List class object
        List<String> al = new ArrayList<>();
  
        // Adding elements to the object
        // Custom inputs
        al.add("Geeks1");
        al.add("Geeks2");
        al.add("Geeks3");
        al.add("Geeks2");
  
        // Adding For at 1st indexes
        al.add(1, "For");
  
        // Print the initialArrayList
        System.out.println("Initial ArrayList " + al);
  
        // Now remove element from the above list
        // present at 1st index
        al.remove(1);
  
        // Print the List after removal of element
        System.out.println("After the Index Removal " + al);
  
        // Now remove the current object from the updated
        // List
        al.remove("Geeks2");
  
        // Finally print the updated List now
        System.out.println("After the Object Removal "
                           + al);

	}

}
