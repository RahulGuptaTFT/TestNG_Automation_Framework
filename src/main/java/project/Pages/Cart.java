package project.Pages;

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

    @FindBy(xpath = "//form[@id='activeCartViewForm']/div[2]/div[3]/div[4]//div[1]/div[3]/div[1]/span[2]/span[1]/input[1]")
    WebElement delete_13_Midnight;

//    @FindBy(xpath = "//form[@id='activeCartViewForm']/div[2]/div[4]/div[4]//div[1]/div[3]/div[1]/span[2]/span[1]/input[1]")
//    WebElement delete_13_Green;


    public void addToCart() {
        addToCart.click();
    }

    public String getCartCount() {
        return cart.getText();
    }

    public void delete_13_Midnight(){
        cart.click();
        delete_13_Midnight.click();
    }
//    public void delete_13_Green(){
//        cart.click();
//        delete_13_Green.click();
//    }
}
