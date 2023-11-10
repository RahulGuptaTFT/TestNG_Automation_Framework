package project.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    WebDriver driver;
    public Cart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;
    @FindBy(id = "nav-cart-count")
    WebElement cart;


    @Step("Clicking submit button step")
    public void addToCart() {
        addToCart.click();
    }

    @Step("Geeting Cart count step")
    public String getCartCount() {
        return cart.getText();
    }

}
