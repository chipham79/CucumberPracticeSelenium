package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageSteps 
{
	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("user proceed to checkout and validate the (.+) items in checkoutpage$")
	public void user_proceed_to_checkout_and_validate(String shortName) throws InterruptedException 
	{
		checkoutPage.checkoutItems();
	}
	
	@And("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException 
	{
		Assert.assertTrue(checkoutPage.verifyApplyBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
	}
	
}
