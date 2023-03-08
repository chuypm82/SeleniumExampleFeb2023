package webdriver.advance.logs;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LoggingExceptionDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		BasicConfigurator.configure();
		Logger loggerParent = LogManager.getLogger("LoggerParent");
		
		try {
			//it will get a divide by zero exception
			int x=200/0;
			
		}catch (Exception exp) {
			loggerParent.warn("Following Excepton was raised", exp);
		}
		
		
		System.out.println("End of Exercise - only one window closed");

	}

}
