package webdriver.advance.logs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogSampleEntry4 {

	static Logger mainLogger = LogManager.getLogger(LogSampleEntry4.class.getName());

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");

		// This is how we create a logger object
		Logger logger1 = LogManager.getLogger("Logger1");
		Logger logger2 = LogManager.getLogger("Logger2");
		Logger logger3 = LogManager.getLogger("Logger3");
		BasicConfigurator.configure();
		logger1.info("This is logger 1");
		logger2.info("This is logger 2");
		logger3.info("This is logger 3");

		Logger rootLogger  = LogManager.getRootLogger();
		Logger rootOf1 = logger1.getRootLogger();


		if(rootOf1.equals(rootLogger))
		{
			rootOf1.info("Both rootLogger and rootOf1 are same objects");	
			rootOf1.info("The Name of the root logger is " + rootLogger.getName());
		}
		else{
		     rootOf1.info("Both rootLogger and rootOf1 are different objects");
		}		

		System.out.println("End of Exercise - only one window closed");

	}

}
