package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks 
{
	TestContextSetup testContextSetup;
	File sourcePath;
	public Hooks(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void AfterScenario() 
	{
		testContextSetup.testBase.WebDriverManage().quit();
	}
	
	@AfterStep
	public void AddScreenShoot(Scenario scenario) throws IOException 
	{
		WebDriver driver = testContextSetup.testBase.WebDriverManage();
		if( scenario.isFailed() )
		{
			//screen shot
			sourcePath =( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
}
