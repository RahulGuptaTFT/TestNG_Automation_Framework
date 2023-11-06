package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Pages.Review;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Set;
@Listeners(project.Utils.Listeners.class)
public class addReview_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test
    public void addReview() throws InterruptedException {
        ExtentTest test = extent.createTest("Checking Add-Review Feature");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        homepage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        dashboard.searchText("nike sneakers");
        dashboard.clickNikeShoes();
        Set<String> all = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(all);
        driver.switchTo().window(tabs.get(1));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,4800)");
        Review review = new Review(driver);
        review.addReview("Great product","I am using this product and it is comfortable.");
        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(0));
    }
}
