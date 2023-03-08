package JavaOOPSamples;

public class ExceptionTest2 {
	static double a[];

	public static void main(String args[]) {
		a = new double[4];
		try {
			printElement(4);
		} catch (Exception e) {
			// Handle exception of type ArrayIndexOutOfBoundsException
			System.out.println("Catch exception :" + e);
		} 
	}

	static void printElement(int i) {
		System.out.println("The 5th element is :" + a[i]);
	}
}
