package JavaOOPSamples;

public class ExceptionTest3 {
	static double a[];

	public static void main(String args[]) {
		a = new double[4];
		try {
			printElement(4); // the four accessible elements include 0, 1, 2, 3
		} catch (Exception e) {
			System.out.println("Catch exception :" + e);
		}finally {
			System.out.println("Here, clean up code can be inplemented");
		}
		
		System.out.println("After Try/Catch");
		
	}

	static void printElement(int i) throws ArrayIndexOutOfBoundsException, MyException {
		
		  if (i >= a.length) {
			   //throw new ArrayIndexOutOfBoundsException("Access element " + (i + 1) + " of an array of length " + a.length);
			  throw new MyException("The code is broken");
		   }
		System.out.println("The 5th element is :" + a[i]);
	}
}
