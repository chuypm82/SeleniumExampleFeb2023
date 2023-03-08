package JavaOOPSamples;

public class MyException extends Exception {

	public MyException(String msg) {
		message = msg;
	}

	private String message;

	public String getMessage() {
		return message;
	}
}
