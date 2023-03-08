package JavaDataStructs;

import java.util.ArrayList;

public class WrapperExample {

	public static void main(String[] args) {

	    char ch = 'a';
	    
        // Autoboxing- primitive to Character object conversion
        Character a = ch;
        
        System.out.println(a);
        
        char c=a;
        System.out.println(a);
        
        int num=10;
        Integer Num=num;
        System.out.println(Num);
        
        Num=20;
        num=Num;
        
        System.out.println(num);
        
  
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
  
        // Autoboxing because ArrayList stores only objects
        arrayList.add(25);
  
        // printing the values from object
        System.out.println(arrayList.get(0));
	}
}
