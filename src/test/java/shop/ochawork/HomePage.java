package shop.ochawork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    public static final By USERNAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By FIRSTNAME = By.id("first-name");
    public static final By LASTNAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "summary_total_label")
    private WebElement totalLabel;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMassage;

    @FindBy(className = "bm-burger-button")
    private WebElement sideMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetLink;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    List<WebElement> inventories = new ArrayList<>();

    List<Item> itemList = new ArrayList<>();

    private void getInventories(){
        inventories.clear();
        itemList.clear();
        inventories = inventoryList.findElements(By.xpath("./child::*"));

        for(WebElement e : inventories){
            Item item = new Item();
            item.setName(e.findElement(By.className("inventory_item_name")).getText());
            item.setPrice(e.findElement(By.className("inventory_item_price")).getText());
            item.setAddToCart(e.findElement(By.tagName("button")));
            itemList.add(item);
        }
    }

    public void addItemToCart(String itemName){
        getInventories();
        for(Item item : itemList){
            if(itemName.equals(item.getName())){
                item.getAddToCart().click();
            }
        }
    }

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSideMenu() { sideMenu.click(); }

    public void clickLogoutLink() { logoutLink.click(); }

    public void addBackPackToCart() {
        addBackpackToCartButton.click();
    }

    public void clickOnCart() {
        shoppingCartLink.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getTotal() {
        return totalLabel.getText();
    }

    public boolean errorMessageShown(){
        return errorMassage.isDisplayed();
    }

    public String getErrorLoginMessage(){
        return errorMassage.getText();
    }

    public void clickResetLink(){
        resetLink.click();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
}
