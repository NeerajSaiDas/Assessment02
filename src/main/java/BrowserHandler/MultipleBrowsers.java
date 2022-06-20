package BrowserHandler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleBrowsers {
	
	public static WebDriver driver;
	
	public static WebDriver getBrowser(String browser) {
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./Drivers/Chrome Driver/chromedriver.exe" );
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver","./Drivers/Edge Driver/msedgedriver.exe" );
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		return driver;
	}

}
