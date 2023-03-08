package webdriver.advance.logs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;



public class LogSampleEntry {
	

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
		
		Logger log = LogManager.getLogger("LogSampleEntry");
				
		//BasicConfigurator.configure();		
		ConsoleAppender appender = new ConsoleAppender();
		appender.activateOptions();
		PatternLayout layoutHelper= new PatternLayout();
		layoutHelper.setConversionPattern("%-5p %c %m%n");
		layoutHelper.activateOptions();
		//mainLogger.getAppender("ConsoleAppender").setLayout(layoutHelper);
		appender.setLayout(layoutHelper);		
		log.addAppender(appender);
		//Create a console appender and attach it to our mainloger
		log.info("Pattern 1 is displayed like this");
		//layoutHelper.setConversionPattern("%C %m%n");
		log.info("Pattern 2 is displayed like this");
		
		System.out.println("End of Exercise - only one window closed");

	}

}
