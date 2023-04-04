package browserFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Run {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Run.class);
		logger.debug("This is a random debug message");
	}

}
