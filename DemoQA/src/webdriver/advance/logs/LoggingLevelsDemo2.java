package webdriver.advance.logs;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LoggingLevelsDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		BasicConfigurator.configure();
		Logger loggerParent = LogManager.getLogger("LoggerParent");
		Logger loggerChild = LogManager.getLogger("LoggerParent.Child");
		
		//setting up the log level of both loggers
		
		loggerParent.setLevel(Level.WARN);
		
		loggerParent.trace("This is the trace log - PARENT");
		loggerParent.debug("This is the debug log - PARENT");
		loggerParent.info("This is the info log - PARENT");
		loggerParent.warn("This is the warn log - PARENT");
		loggerParent.error("This is the error log - PARENT");
		loggerParent.fatal("This is the fatal log - PARENT");
		
		loggerChild.trace("This is the trace log - CHILD");
		loggerChild.debug("This is the debug log - CHILD");
		loggerChild.info("This is the info log - CHILD");
		loggerChild.warn("This is the warn log - CHILD");
		loggerChild.error("This is the error log - CHILD");
		loggerChild.fatal("This is the fatal log - CHILD");
		
		System.out.println("End of Exercise - only one window closed");

	}

}
