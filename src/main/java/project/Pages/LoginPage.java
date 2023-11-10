package project.Pages;

import io.qameta.allure.Step;
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

    @Step("Adding Email step")
    public void addEmail(String text) {
        email.sendKeys(text);
    }
    @Step("Clicking continue button step")
    public void clickContinue() {
        Continue.click();
    }
    @Step("Adding password step")
    public void addPassword(String text) {
        pass.sendKeys(text);
    }
    @Step("Clicking submit button step")
    public void clickSubmit() {
        submit.click();
    }
}
