package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.*;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;
@Listeners(project.Utils.Listeners.class)
public class cartCountUpdate_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(description = "Verifying cart count Test")
    @Description("Verifying cart count Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Checking product count in cart on amazon")
    public void getCartCount() {
        ExtentTest test = extent.createTest("Checking if Cart is showing right quantity");
        test.pass("verified");
        LandingPage landingPage = new LandingPage(driver);
        if (landingPage.checkYourAccountIsDisplayed() == true){
            landingPage.clickYourAccount();
        }
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        Cart cart = new Cart(driver);
        int count = Integer.parseInt(cart.getCartCount());
        System.out.println(count);
        Assert.assertEquals(count > 0,false);

    }
}
