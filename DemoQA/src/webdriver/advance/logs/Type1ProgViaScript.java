package webdriver.advance.logs;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;



public class Type1ProgViaScript {
	
	static Logger log = LogManager.getLogger("LogSampleEntry");

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		//BasicConfigurator.configure();
		ConsoleAppender appender= new ConsoleAppender();
		log.addAppender(appender);
		appender.activateOptions();
		PatternLayout layoutHelper = new PatternLayout();
		layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
		layoutHelper.activateOptions();
		appender.setLayout(layoutHelper);		
		log.addAppender(appender);		
		log.info("This is just a logger");
		layoutHelper.setConversionPattern("%c %m%n");
		log.info("This is just a logger second line");
		
		System.out.println("End of Exercise - only one window closed");

	}

}
