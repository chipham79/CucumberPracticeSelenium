package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HomePage;
import utils.SeleniumDriver;

public class CarWaleSteps
{
    HomePage homePage = new HomePage();

    @Given("user navigate to carwale website")
    public void user_navigate_to_carwale_website() {
        SeleniumDriver.openPage(SeleniumDriver.config.getProperty("test_site_url"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user mouseover to new cars")
    public void user_mouseover_to_new_cars() {
        homePage.mouseOverNewCars();
    }

    @When("user clicks on Findnewcars")
    public void user_clicks_on_findnewcars() {
        homePage.clickFindNewCars();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("user clicks on Toyota car")
    public void user_clicks_on_toyota_car() {

    }

    @Then("user validates title car as Toyota Cars")
    public void user_validates_title_car_as_toyota_cars() {

    }
}
