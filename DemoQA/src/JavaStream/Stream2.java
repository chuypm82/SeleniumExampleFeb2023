package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class Stream2 {

	public static void main(String[] args) {

		 // create a list of integers
	    List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
	    values.stream().sorted().forEach(s->System.out.println(s));
	    
	    System.out.println("Distinct values");
	    values.stream().distinct().sorted().forEach(s->System.out.println(s));
	    
	    System.out.println("Give third index");
	    List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
	    System.out.println(li.get(2));
	  

	    
	}

}
