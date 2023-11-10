package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Homepage;
import project.Pages.LandingPage;
import project.Pages.LoginPage;
import project.Pages.Wishlist;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;
@Listeners(project.Utils.Listeners.class)
public class removeItemFromWishlist extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(description = "Verifying remove from wishlist Test")
    @Description("Verifying remove from wishlist Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Removing product from wishlist on amazon")
    public void removefromWishlist(){
        ExtentTest test = extent.createTest("Checking Remove Feature from wishlist");
        test.info("verified");
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

        Wishlist wishlist = new Wishlist(driver);
        wishlist.deleteWishlist();

    }
}
