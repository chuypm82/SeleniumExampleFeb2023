package ParallelWebdriverListenerRetry3WorksWell;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ImageResult extends SelTestCase {
	
	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		String filePath=System.getProperty("user.dir") + "\\reports\\" + testCaseName + System.currentTimeMillis() + ".png";
		File file = new File(filePath);
		FileUtils.copyFile(source, file);
		return filePath;
	}
}
