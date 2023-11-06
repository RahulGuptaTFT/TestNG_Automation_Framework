package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.Pages.Cart;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

public class cartCountUpdate_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(groups = "Cart")
    public void getCartCount() {
        ExtentTest test = extent.createTest("Checking if Cart is showing right quantity");
        test.pass("verified");
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
        Assert.assertEquals(count > 0,true);

    }
}
