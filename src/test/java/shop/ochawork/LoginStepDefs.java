package shop.ochawork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {


    @And("the Password is filled with {string}")
    public void thePasswordIsFilledWithSecret_sauce(String password) {
        homePage.fillField(HomePage.PASSWORD, password);
    }

    @And("the Username is filled with {string}")
    public void theUsernameIsFilledWithStandard_user(String userName) {
        homePage.fillField(HomePage.USERNAME, userName);
    }

    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginButton();
    }

    @Then("the Login error should be shown")
    public void loginErrorShouldBeShown(){ homePage.errorMessageShown(); }

    @Then("the Locked out error should be shown")
    public void lockOutErrorShouldBeShown(){
        assertEquals(homePage.getErrorLoginMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Then("Login should be successful")
    public void loginShouldBeSuccessful(){
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @And("the Logout link is clicked")
    public void theLogoutLinkIsClicked() {
        homePage.clickLogoutLink();
    }

    @Then("Logout should be successful")
    public void logoutShouldBeSuccessful(){
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }
}
