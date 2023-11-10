package project.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='Categories']")
    WebElement categories;
    @FindBy(linkText = "Your Account")
    WebElement yourAccount;
@FindBy(id = "nav-bb-search")
WebElement textbar;

    @Step("Checking your-account button displayed or not step")
    public boolean checkYourAccountIsDisplayed(){
        boolean ans = yourAccount.isDisplayed();
        return ans;
    }
    @Step("Clicking on your-account")
    public void clickYourAccount(){
        yourAccount.click();
    }
}
