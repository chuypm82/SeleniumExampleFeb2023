package JavaDataStructs;

public class ArrayToMethods2 {

	public static void main(String[] args) {

		 int arr[] = m1();
		 
	        //for (int i = 0; i < arr.length; i++)
	          //  System.out.print(arr[i] + " ");  
		 for(int a: arr)
			 System.out.print(a + " ");
		 
		 System.out.println();
		 
		 int intArray[] = new int[3];
	        byte byteArray[] = new byte[3];
	        short shortsArray[] = new short[3];
	 
	        // array of Strings
	        String[] strArray = new String[3];
	 
	        System.out.println(intArray.getClass());
	        System.out.println(
	            intArray.getClass().getSuperclass());
	        System.out.println(byteArray.getClass());
	        System.out.println(shortsArray.getClass());
	        System.out.println(strArray.getClass());
		 
		 
	}
	
	private static int[] m1() {
		
		//int[] intArray= new int[]{1,2,3,4,5};
		//returing array
		return new int[]{1,2,3,4,5};
	}
}
