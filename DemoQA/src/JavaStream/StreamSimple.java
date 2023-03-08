package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class StreamSimple {

	public static void main(String[] args) {

		 // create a list of integers
	    List<Integer> num = Arrays.asList(2,3,4,5,6,7,2,3);
	  
	    // demonstration of map method
	    List<Integer> mul = num.stream().map(x -> x*x).collect(Collectors.toList());
	    System.out.println(mul);
	  
	    
	    // create a list of String
	    List<String> names =Arrays.asList("Window","System","Computer", "Array");
	  
	    // demonstration of filter method
	    List<String> filter = names.stream().filter(x->x.startsWith("W")).collect(Collectors.toList());
	    System.out.println(filter);

	    List<String> sorted=names.stream().sorted().collect(Collectors.toList());
	    System.out.println(sorted);
	    
	    Set<Integer> mulSet=num.stream().map(x->x*x).collect(Collectors.toSet());
	    System.out.println(mulSet);
	    
	    num.stream().map(x->x*x).forEach(y->System.out.println(y));
	    
	    List<Integer> filter2 = num.stream().filter(x->x%2==0).collect(Collectors.toList());
	    System.out.println(filter2);
	    
	    int even=num.stream().filter(x->x%2==0).reduce(0,(ans,i)->ans+i);
	    System.out.println(even);
	    
	}

}
