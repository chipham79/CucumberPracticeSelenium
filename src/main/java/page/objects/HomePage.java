package page.objects;

import pages.base.BasePage;

public class HomePage extends BasePage
{
    public void mouseOverNewCars() {
        mouseOver("newCarMenu_XPATH");
    }

    public void clickFindNewCars() {
        click("findNewCars_XPATH");
    }

    public void searchCars() {

    }
}
