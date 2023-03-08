package JavaDataStructs;

import java.util.ArrayList;
import java.util.List;

public class ArraySimple {

	public static void main(String[] args) {

		int intArray[];
		int[] intArray2;//valid way as well
		
		intArray= new int[5];
		
		int intArray3[]= new int[5];
		
		int[] intArray4= new int[] {1,2,3,4,5};
		
		int[] intArray5= {1,2,3,4,5};
		
		//System.out.println(intArray5);
		
		intArray5[4]=6;
		
		for(int i=0; i< intArray5.length; i++)
			System.out.println("Element at index " + i + " : " + intArray5[i]);
		
		for(int e :intArray5 )
			System.out.println(e);
			
	       
	}
}
