package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String takeScreenshot(WebDriver driver,String fileName) {
		String logFileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		fileName = fileName + logFileName;
		String directory = System.getProperty("user.dir") + "/Screenshots/";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File(directory + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String destination = directory + fileName;
		return destination;
	}

}
