package JavaDataStructs;

public class ArrayToMethods {

	public static void main(String[] args) {

		 int arr[] = { 3, 1, 2, 5, 4 };
		 
	        // passing array to method m1
	        sum(arr);	       
	}
	
	private static void sum(int[] a) {
		
		int sum=0;
		for(int i=0; i<a.length; i++) {
			sum= sum+a[i];
		}
		
		System.out.println("Sum of array values: " + sum);
	}
}
