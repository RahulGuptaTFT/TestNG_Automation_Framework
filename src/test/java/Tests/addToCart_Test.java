package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.*;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;
import java.util.ArrayList;
import java.util.Set;
@Listeners(project.Utils.Listeners.class)
public class addToCart_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();


    @Test(dataProvider = "searchItems",description = "Verifying add-to-cart Test")
    @Description("Verifying add-to-cart Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Adding product in cart on amazon")
    public void addTocart_Test(String searchObject) throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Add-to-cart Feature");
        test.info("If the cart total cost goes upto 1 Lakh Rupees, It will not add further");
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
        dashboard.searchText(searchObject);
        if (searchObject.equalsIgnoreCase("asitis whey protein")) {
            dashboard.clickAsitis();
        }else {
            dashboard.clickAirpod();
        }
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));
        Cart cart = new Cart(driver);
        cart.addToCart();

        driver.close();
        driver.switchTo().window(tabs.get(0));

        dashboard.clearTextFromSearchBar();
    }

    @DataProvider(name = "searchItems")
    public Object[] items() {
        Object[] data = new Object[2];
        data[0] = "asitis whey protein";
        data[1] = "airpod pro 2nd generation";
        return data;
    }
}
