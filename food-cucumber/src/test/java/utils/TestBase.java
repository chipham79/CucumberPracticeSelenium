package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver  WebDriverManage() 
	{
		if(driver == null) 
		{
			System.setProperty("webdriver.gecko.driver","/Users/chi.pham/eclipse-workspace/Project/CucumberPracticeSelenium/food-cucumber/webdrivers/geckodriver.exe");
		    driver = new FirefoxDriver();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}

		return driver;
	}

}
