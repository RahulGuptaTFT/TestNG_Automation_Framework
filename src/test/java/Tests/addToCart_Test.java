package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.DataProvider;
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
public class addToCart_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(dataProvider = "searchItems",groups = "Cart")
    public void addTocart_Test(String searchObject) throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Add-to-cart Feature");
        test.info("If the cart total cost goes upto 1 Lakh Rupees, It will not add further");
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        dashboard.searchText(searchObject);
        if (searchObject.equalsIgnoreCase("oneplus neckband z2")) {
            dashboard.clickOnePlusNeckband();
        }else {
            dashboard.clickFastTrackWatch();
        }
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));
        Cart cart = new Cart(driver);
        cart.addToCart();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        dashboard.clearTextFromSearchBar();

    }

    @DataProvider(name = "searchItems")
    public Object[] items() {
        Object[] data = new Object[2];
        data[0] = "oneplus neckband z2";
        data[1] = "fasttrack watch";
        return data;
    }
}
