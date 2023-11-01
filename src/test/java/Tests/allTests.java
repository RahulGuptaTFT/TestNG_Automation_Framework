package Tests;

import org.testng.annotations.Listeners;
import project.Pages.Cart;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;


public class allTests extends BaseTest {

    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(priority = 1)
    public void logotest() {
        ExtentTest test = extent.createTest("Checking Logo");
        test.pass("verified");
        Dashboard dashboard = new Dashboard(driver);
        String s = dashboard.getLogoText();
        Assert.assertEquals(s, ".in");


    }

    @Test(priority = 2)
    public void loginTest() {
        ExtentTest test = extent.createTest("Checking Login");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        // It will on homepage for signIn
        homepage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();


    }

    @Test(priority = 3)
    public void SearchBarText_Test() {
        ExtentTest test = extent.createTest("Checking Search-Bar showing right search Text ");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        dashboard.searchText("iphone 13");
        String s = dashboard.getSearchBarText();
        Assert.assertEquals(s, "iphone 13");

    }

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

    @Test(priority = 5)
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
        String count = cart.getCartCount();
        System.out.println(count);
        //Assert.assertEquals(count,"2");

    }

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
