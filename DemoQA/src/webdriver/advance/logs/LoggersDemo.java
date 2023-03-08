package webdriver.advance.logs;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LoggersDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		Logger chance = LogManager.getLogger(LoggersDemo.class.getName());
		Logger logger1 = LogManager.getLogger("Child1");
		Logger logger1Child = logger1.getLogger("Child1.ChildOfLogger1");
		Logger loggerGrandChild = LogManager.getLogger("Child1.ChildOfLogger1.GrandChild");
		
		System.out.println("Logger1's fill name is: " + logger1.getParent().getName());
		System.out.println("Logger1Child's fill name is: " + logger1Child.getParent().getName());
		System.out.println("LoggerGrandChild's fill name is: " + loggerGrandChild.getParent().getName());
		
		System.out.println("End of Exercise - only one window closed");

	}

}
