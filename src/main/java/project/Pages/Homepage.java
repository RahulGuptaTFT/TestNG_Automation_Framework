package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    WebDriver driver;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement signIn_1;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']/a[1]/span[text()='Sign in']")
//    static By signIn_2;

    public void clickSignIn() {
//        Actions act = new Actions(driver);
//        act.moveToElement(driver.findElement(signIn_1)).moveToElement(driver.findElement(signIn_2)).click().build().perform();
        signIn_1.click();
    }

}
