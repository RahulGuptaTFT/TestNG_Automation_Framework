package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "ap_email")
    WebElement email;
    @FindBy(id = "continue")
    WebElement Continue;
    @FindBy(id = "ap_password")
    WebElement pass;
    @FindBy(id = "signInSubmit")
    WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmail(String text) {
        email.sendKeys(text);
    }

    public void clickContinue() {
        Continue.click();
    }

    public void addPassword(String text) {
        pass.sendKeys(text);
    }

    public void clickSubmit() {
        submit.click();
    }
}
