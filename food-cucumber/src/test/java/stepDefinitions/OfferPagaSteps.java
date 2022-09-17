package stepDefinitions;

import org.junit.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPagaSteps 
{
	public TestContextSetup testContextSetup;
	public String offerPageProductName;
	PageObjectManager pageObjectManager;
	
	public OfferPagaSteps(TestContextSetup testContextSetup) { 
		this.testContextSetup = testContextSetup;
	}
	public void switchToOfferPage() throws InterruptedException 
	{
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		
		testContextSetup.genericUtils.switchWindowToChild();
	}
	@And("user searched for {string} shortname in offers page to check if product exist with same name")
	public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String shortName) throws InterruptedException 
	{
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		
		switchToOfferPage();
		
		offersPage.searchItem(shortName);;
		offerPageProductName = offersPage.getProductName();
		
		System.out.println(offerPageProductName + " is extracted from Offer page");
	}
	
	@And("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}
