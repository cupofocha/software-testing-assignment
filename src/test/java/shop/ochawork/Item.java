package shop.ochawork;

import org.openqa.selenium.WebElement;

public class Item {
    private String name;

    private String Price;

    private WebElement addToCart;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setAddToCart(WebElement addToCart) {
        this.addToCart = addToCart;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return Price;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public Item(String name, String price, WebElement addToCart) {
        this.name = name;
        Price = price;
        this.addToCart = addToCart;
    }

    public Item(){}
}
