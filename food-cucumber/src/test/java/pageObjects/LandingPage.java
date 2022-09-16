package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage 
{
	public WebDriver driver;
	
    public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By search = By.cssSelector("input.search-keyword");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By quantity = By.cssSelector("input.quantity");
	private By addToCartBtn = By.xpath("//button[contains(text(), 'ADD TO CART')]");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getTextSearch( )
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName() 
	{
		String value = driver.findElement(productName).getText();
		return value;
	}
	
	public void selectTopDealsPage( )
	{
		driver.findElement(topDeals).click();;
	}
	
	public String getTitleLandingPage() 
	{
		return driver.getTitle();
	}
	
	public void setTextQuantityProduct(String value)
	{
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(value);
	}
	
	
	public void clickAddToCartBtn() 
	{
		driver.findElement(addToCartBtn).click();
	}
}
