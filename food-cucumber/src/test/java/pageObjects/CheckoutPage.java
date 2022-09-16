package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	public WebDriver driver;
	
    public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By proccedToCheckoutBtn = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	private By applyBtn = By.cssSelector("button.promoBtn");
	private By placeOrderBtn = By.xpath("//button[contains(text(), 'Place Order')]");
	private By cartBag = By.cssSelector("img[alt='Cart']");
	
	public void checkoutItems() 
	{
		driver.findElement(cartBag).click();
		driver.findElement(proccedToCheckoutBtn).click();
	}
	
	public boolean verifyApplyBtn() throws InterruptedException 
	{
		Thread.sleep(3000);
		return driver.findElement(applyBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrderBtn() throws InterruptedException 
	{
		Thread.sleep(3000);
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	
}
