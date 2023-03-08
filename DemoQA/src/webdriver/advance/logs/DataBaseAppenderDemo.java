package webdriver.advance.logs;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.jdbc.JDBCAppender;

public class DataBaseAppenderDemo {

	static Logger mainLogger = LogManager.getLogger(DataBaseAppenderDemo.class.getName());

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser");

		Logger ourLogger = LogManager.getLogger("OurLogger");
		
		//Create a JDBCAppender class instance 		
		JDBCAppender dataBaseAppender= new JDBCAppender();
		dataBaseAppender.setURL("jdbc:mysql://localhost/test");// Connection url
		dataBaseAppender.setUser("User1");
		dataBaseAppender.setPassword("ThisPassword");
		dataBaseAppender.setDriver("com.mysql.jdbc.Driver");//Drivers to use to connect to DB
		
		//Set the sql insert statement that you want to use
		dataBaseAppender.setSql("INSERT INTO LOGS VALUES ('%X', now(), '%C', '%p', '%m'");
		
		
		
		//activate new options
		dataBaseAppender.activateOptions();
		
		//attach the appender to the logger
		ourLogger.addAppender(dataBaseAppender);
		
		//lets print some log 10 times
		int x=0;
		while(x<11) {
			ourLogger.debug("This is just a log that I want to print " + x);
			x++;
		}
		

		System.out.println("End of Exercise - only one window closed");

	}

}
