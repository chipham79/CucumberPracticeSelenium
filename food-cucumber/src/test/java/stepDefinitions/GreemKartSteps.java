package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreemKartSteps 
{	
	public WebDriver driver;
	
	@Given("User is on GreenCart Lading Page")
	public void user_is_on_green_cart_lading_page() 
	{
		 System.setProperty("webdriver.chrome.driver", "/food-cucumber/webdrivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user search with Shortname {string} and extracted actual name of product")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName) 
	{
		driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(shortName);
		String ladingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(ladingPageProductName + " is extracted from Home page");
		
	}
	@Then("user searched for {string} shortname in offers page to check if product exist with same name")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) 
	{
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		String parentWindow = window.next();
		String childWindow = window.next();
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.id("search-field")).sendKeys(shortName);
		String offerPageProductName = driver.findElement(By.cssSelector("")).getText();
		System.out.println(offerPageProductName + " is extracted from Home page");
		
	}
	
	@And("And validate product name in offers page matches with Landing Page")
	private void validate_product_name() {
		

	}


}
