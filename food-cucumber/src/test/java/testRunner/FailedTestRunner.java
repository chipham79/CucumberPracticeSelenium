package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "stepDefinitions",
		plugin = {"html:target/cucumber-report.html", "json:target/cucumber.json",  
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class FailedTestRunner {

}
