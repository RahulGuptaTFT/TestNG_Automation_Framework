package Tests;

import project.Pages.Cart;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import project.basetest.BaseTest;


public class deleteFromCart_Test extends BaseTest {

    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(priority = 6)
    public void delete_From_cart_Midnight() {

        ExtentTest test = extent.createTest("Checking Delete Product");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Cart cart = new Cart(driver);
        cart.delete_13_Midnight();

    }
}
