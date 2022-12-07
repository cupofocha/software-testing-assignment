package shop.ochawork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs{

    @Given("the homepage is open")
    public void theHomepageIsOpen() {
        homePage.openPage();
    }

    @And("side Menu is clicked")
    public void sideMenuIsClicked(){ homePage.clickSideMenu(); }

    @And("reset Link is clicked")
    public void resetLinkIsClicked(){ homePage.clickResetLink();}

    @And("page is refreshed")
    public void pageIsRefreshed(){ homePage.refreshPage(); }
}
