package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import project.Pages.Cart;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;

public class addToCart_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(priority = 4)
    public void addTocart_Test() throws InterruptedException {
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
        //green iphone
        dashboard.searchText("iphone 13");
        dashboard.clickIphone13_Green();
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));
        Cart cart = new Cart(driver);
        cart.addToCart();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tabs.get(0));


        Thread.sleep(2000);

        //midnight iphone
        dashboard.clickIphone13_Midnight();
        Set<String> all1 = driver.getWindowHandles();
        ArrayList<String> tabs1 = new ArrayList<>(all1);
        driver.switchTo().window(tabs1.get(1));
        cart.addToCart();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tabs1.get(0));


    }

}
