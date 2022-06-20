package StepDefinitios;


import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BrowserHandler.MultipleBrowsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps {
	
	static WebElement element;
	static Actions act;
	static JavascriptExecutor JSE;
	static WebDriver driver;
	
	@Before
	public void beforeHook() {
		System.out.println("BeforeHook");
	}
	
	@Given("User should be on Home Page.")
	public void user_should_be_on_home_page() {
		driver = MultipleBrowsers.driver;
		System.out.println(driver.getTitle());
	}

	@When("User hover on Laptops.")
	public void user_hover_on_laptops() {
		element = driver.findElement(By.xpath("//div[@class=\"hpg-cat-item-wrap dds__px-2\"]"));
	    act = new Actions(driver);                                                                  // Use of Actions
		act.moveToElement(element).perform();
	}

	@When("User click on For Home.")
	public void user_click_on_for_home() {
		element = driver.findElement(By.xpath("//div/a[@aria-label='Laptops For Home']"));
	    element.click(); 
	}

	@When("User scroll down on HomePage.")
	public void user_scroll_down_on_home_page() {
		element = driver.findElement(By.xpath("//div/a[@title='Explore Alienware']"));
		JSE = (JavascriptExecutor) driver;                                  // Use of Javascript Executor
		JSE.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	@When("User click on Explore Inspiron.")
	public void user_click_on_explore_inspiron() {
		element.click();
	}
	
	@Then("User should land on Explore Inspiron page.")
	public void user_should_land_on_explore_inspiron_page() {
		System.out.println(driver.getTitle());
	}

	@Then("User should navigate to Home Page.")
	public void user_should_navigate_to_home_page() {
	   driver.navigate().back();
	   driver.navigate().back();
	   System.out.println(driver.getTitle());
	}
	
	@After
	public void afterHook() {
		System.out.println("AfterHook");
	}

}
