package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;
@Listeners(project.Utils.Listeners.class)
public class compareProduct_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();
    @Test
    public void compare() throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Compare Product Feature");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2000)");
        dashboard.searchText("airpod pro 2nd generation");
        dashboard.clickAirpod();
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));

        js.executeScript("window.scrollBy(0,5500)");

        Assert.assertTrue(dashboard.checkCompareIsDisplayed());
    }
}
