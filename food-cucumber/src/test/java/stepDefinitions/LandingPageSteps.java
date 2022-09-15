package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageSteps 
{	
	public WebDriver driver;
	public String ladingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	
	public LandingPageSteps(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Given("User is on GreenCart Lading Page")
	public void user_is_on_green_cart_lading_page() 
	{
		 //String path = System.getProperty("user.dir");
//		 System.setProperty("webdriver.chrome.driver", "/Users/chi.pham/eclipse-workspace/Project/CucumberPracticeSelenium/food-cucumber/webdrivers/chromedriver.exe");
//		 driver = new ChromeDriver();

	}
	
	@When("user search with Shortname {string} and extracted actual name of product")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		
		landingPage.searchItem(shortName);
		
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
	}
	
}
