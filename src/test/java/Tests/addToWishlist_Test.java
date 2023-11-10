package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.*;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;
@Listeners(project.Utils.Listeners.class)
public class addToWishlist_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(description = "Verifying add to wishlist Test")
    @Description("Verifying add to wishlist Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Adding product in wishlist on amazon")
    public void addToWishList() throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Add-to-wishlist Feature");
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
        //oneplus neckband
        dashboard.searchText("airpod pro 2nd generation");
        dashboard.clickAirpod();
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));
        Wishlist wishlist = new Wishlist(driver);
        wishlist.addToWishlist();

        driver.close();
        driver.switchTo().window(tabs.get(0));

        dashboard.clearTextFromSearchBar();
    }
}
