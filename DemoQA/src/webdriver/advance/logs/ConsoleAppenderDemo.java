package webdriver.advance.logs;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class ConsoleAppenderDemo {

	static Logger mainLogger = LogManager.getLogger(ConsoleAppenderDemo.class.getName());

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");

		Logger ourLogger = LogManager.getLogger("OurLogger");
		
		//Create a ConsoleAppender object 
		// You will also have to set a layout also, here we have chosen a SimpleLayout
		ConsoleAppender consoleAppender= new ConsoleAppender();
		consoleAppender.setLayout(new SimpleLayout());
		
		//add the appender to our Logger OBject. From now onwards all the logs will be directed
		// to file mentioned by File Appender
		ourLogger.addAppender(consoleAppender);
		consoleAppender.activateOptions();
		
		//lets print some log 10 times
		int x=0;
		while(x<11) {
			ourLogger.debug("This is just a log that I want to print " + x);
			x++;
		}
		

		System.out.println("End of Exercise - only one window closed");

	}

}
