package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Pages.Wishlist;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

public class removeItemFromWishlist extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(groups = "Wishlist")
    public void removefromWishlist(){
        ExtentTest test = extent.createTest("Checking Remove Feature from wishlist");
        test.info("verified");
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
