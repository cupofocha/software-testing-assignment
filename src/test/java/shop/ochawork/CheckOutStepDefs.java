package shop.ochawork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckOutStepDefs extends AbstractStepDefs{
    @And("the First Name is filled with {string}")
    public void theFirstNameIsFilledWithA(String firstName) {
        homePage.fillField(HomePage.FIRSTNAME, firstName);
    }

    @And("the Last Name is filled with {string}")
    public void theLastNameIsFilledWithB(String lastName) {
        homePage.fillField(HomePage.LASTNAME, lastName);
    }

    @And("the Zip Code is filled with {string}")
    public void theZipCodeIsFilledWith(String zipCode) {
        homePage.fillField(HomePage.POSTAL_CODE, zipCode);
    }

    @When("the Continue button is clicked")
    public void theContinueButtonIsClicked() {
        homePage.clickContinueButton();
    }

    @Then("{string} should be shown")
    public void total$ShouldBeShown(String total) {
        Assert.assertEquals(total, homePage.getTotal());
    }
}
