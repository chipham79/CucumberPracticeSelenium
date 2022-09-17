package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver  WebDriverManage() throws IOException 
	{
		String userDirectory = System.getProperty("user.dir");
		FileInputStream fis;
		Properties prop = new Properties();
		
		fis = new FileInputStream(userDirectory + "/src/test/resources/global.properties");
		prop.load(fis);
	
		String url = prop.getProperty("url");
		String brower = prop.getProperty("broswer");
		
		if(driver == null) 
		{
			if( brower.equalsIgnoreCase("firefox") ) 
			{
				System.setProperty("webdriver.gecko.driver", userDirectory + "/webdrivers/geckodriver.exe");
			    driver = new FirefoxDriver();
			}
			
			if( brower.equalsIgnoreCase("chrome") ) 
			{
				System.setProperty("webdriver.gecko.driver", userDirectory + "/webdrivers/chromedriver.exe");
			    driver = new ChromeDriver();				
			}
			
			driver.get(url);
		}

		return driver;
	}

}
