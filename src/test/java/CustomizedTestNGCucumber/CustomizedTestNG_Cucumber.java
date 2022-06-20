package CustomizedTestNGCucumber;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BrowserHandler.MultipleBrowsers;
import PropertiesLoader.PropertiesReader;
import Utility.ExcelReader;
import Utility.Screenshot;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class CustomizedTestNG_Cucumber extends AbstractTestNGCucumberTests{
 
	public static WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	

  @BeforeClass
  public void beforeClass() {
	
	  report = new ExtentReports("./ExtentReprts/Report.html",false);
	  test = report.startTest("DemoTest");
  }
  
  @Parameters({"browser"})                                                         // Use of Parameter
  @BeforeTest
  public void beforeTest(String browser) throws IOException {
	  driver = MultipleBrowsers.getBrowser(PropertiesReader.readBrowser(browser));
	  driver.get(PropertiesReader.readBaseURL());
  }
  
  @Test(priority=1)
  public void methods() {
	  System.out.println("Ram Sai");
  }
  
  @Test(priority=2)
  public void check() {
	  Assert.assertEquals(false, true);                                               // Use of Assert
	  driver.switchTo().frame(3);                                //iFrame
  }
  
  @DataProvider(name="ExcelData")                                                  // Use of DataProvider
  public static Object[][] loginData() throws EncryptedDocumentException, IOException {
	  Object[][] data = ExcelReader.readExcelData("Login Sheet");
	  return data;
  }
  
  @Test(dataProvider ="ExcelData",priority=3)
  public void login(String S1, String S2, String S3) {
	  System.out.println(S1+S2+S3);
  }
  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
	  if(testResult.getStatus() == ITestResult.FAILURE ) {
		  String path = Screenshot.takeScreenshot(driver, testResult.getName());
		  String imagePath =test.addScreenCapture(path);
		  test.log(LogStatus.FAIL,"failed",imagePath);
	  }else {
		  test.log(LogStatus.PASS,"passed","");
	  }
  }

  @AfterClass
  public void afterClass() {
	  report.endTest(test);
	  report.flush();
	  driver.close();
  }

}
