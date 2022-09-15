package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage 
{
	public WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By search = By.cssSelector("search-field");
	private By productName = By.cssSelector("tbody tr td:nth-child(1)");
	
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
		
}
