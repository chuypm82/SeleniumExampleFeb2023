package webdriver.advance.logs;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LoggingLevelsDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		BasicConfigurator.configure();
		Logger myLogger = LogManager.getLogger("DebugLogger");
		
		myLogger.setLevel(Level.INFO);
		
		myLogger.trace("This is the trace log - DEGUB");
		myLogger.debug("This is the debug log - DEGUB");
		myLogger.info("This is the info log - DEGUB");
		myLogger.warn("This is the warn log - DEGUB");
		myLogger.error("This is the error log - DEGUB");
		myLogger.fatal("This is the fatal log - DEGUB");
		
		myLogger.setLevel(Level.ERROR);
		myLogger.trace("This is the trace log - WARN");
		myLogger.debug("This is the debug log - WARN");
		myLogger.info("This is the info log - WARN");
		myLogger.warn("This is the warn log - WARN");
		myLogger.error("This is the error log - WARN");
		myLogger.fatal("This is the fatal log - WARN");
		
		System.out.println("End of Exercise - only one window closed");

	}

}
