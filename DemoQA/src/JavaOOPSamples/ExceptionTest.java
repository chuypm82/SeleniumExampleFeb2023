package JavaOOPSamples;

public class ExceptionTest {
	static double a[];

	public static void main(String args[]) {
		a = new double[4];
		try {
			printElement(4);
		} catch (ArrayIndexOutOfBoundsException e) {
			// Handle exception of type ArrayIndexOutOfBoundsException
			System.out.println("Catch exception :" + e);
		} catch (Exception e1) {
			// Handle exception of type Exception
		}
	}

	static void printElement(int i) {
		System.out.println("The 5th element is :" + a[i]);
	}
}
