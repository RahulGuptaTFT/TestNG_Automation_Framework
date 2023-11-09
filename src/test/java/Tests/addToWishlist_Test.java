package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Cart;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;
@Listeners(project.Utils.Listeners.class)
public class addToWishlist_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(groups = "Wishlist")
    public void addToWishList() throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Add-to-wishlist Feature");
        test.pass("verified");
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
        Cart cart = new Cart(driver);
        cart.addToWishlist();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        dashboard.clearTextFromSearchBar();
    }
}
