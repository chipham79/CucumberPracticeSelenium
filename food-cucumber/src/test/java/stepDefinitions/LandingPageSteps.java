package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
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
	public LandingPage landingPage;
	
	public LandingPageSteps(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Lading Page")
	public void user_is_on_green_cart_lading_page() 
	{
		String titlePage = landingPage.getTitleLandingPage();
		Assert.assertTrue(titlePage.contains("GreenKart"));
	
	}
	
	@When("user search with Shortname (.+) and extracted actual name of product$")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{		
		landingPage.searchItem(shortName);
		
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
	}
	
	@And("added {string} items of the selected product to cart")
	public void add_number_items_of_the_selected_product_to_cart(String quantity) 
	{
		landingPage.setTextQuantityProduct(quantity);
		landingPage.clickAddToCartBtn();
	}
	
}
