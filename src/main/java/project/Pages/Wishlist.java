package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class Wishlist {
    WebDriver driver;
    public Wishlist(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Account & Lists']")
    WebElement accountsAndLists;
    @FindBy(xpath = "//span[text()='Your Wish List']")
    WebElement yourWishlist;
    @FindBy(xpath = "//input[@name='submit.deleteItem']")
    WebElement deleteFromWishlist;

    public void deleteWishlist() {
        Actions act = new Actions(driver);
        act.moveToElement(accountsAndLists).moveToElement(yourWishlist).click().build().perform();
        deleteFromWishlist.click();
    }
}
