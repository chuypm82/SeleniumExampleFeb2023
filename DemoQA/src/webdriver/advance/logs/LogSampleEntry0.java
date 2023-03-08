package webdriver.advance.logs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LogSampleEntry0 {
	
	static Logger log = LogManager.getLogger("LogSampleEntry");

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");
				
		BasicConfigurator.configure();
		log.info("This is just a logger");
		log.info("This is just a logger second line");
		
		System.out.println("End of Exercise - only one window closed");

	}

}
