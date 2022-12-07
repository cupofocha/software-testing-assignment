package shop.ochawork;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CartStepDefs extends AbstractStepDefs{
    //@Given("the Sauce Labs Backpack is added to the cart")
    //public void theSauceLabsBackpackIsAddedToTheCart() {homePage.addBackPackToCart();}

    @Given("the {string} is added to the cart")
    public void theItemIsAddedToTheCart(String item){ homePage.addItemToCart(item);}

    @Given("the {string} is removed")
    public void theItemIsRemoved(String item){ homePage.removeItem(item);}

    @And("the cart icon is clicked")
    public void theCartIconIsClicked() {
        homePage.clickOnCart();
    }

    @And("the checkout button is clicked")
    public void theCheckoutButtonIsClicked() {
        homePage.clickCheckoutButton();
    }


}
