package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup 
{
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() 
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManage());
		genericUtils = new GenericUtils(testBase.WebDriverManage());
		
	}
}
