package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LandingPage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;
@Listeners(project.Utils.Listeners.class)
public class Filters_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(description = "Verifying Filter Test")
    @Description("Verifying Filter Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Applying filters on product on amazon")
    public void filter() {
        ExtentTest test = extent.createTest("Checking Filters");
        test.pass("verified");
        LandingPage landingPage = new LandingPage(driver);
        if (landingPage.checkYourAccountIsDisplayed() == true){
            landingPage.clickYourAccount();
        }
        Homepage homepage = new Homepage(driver);
        // It will on homepage for signIn
        homepage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.addEmail(id);
        loginPage.clickContinue();
        loginPage.addPassword(pass);
        loginPage.clickSubmit();

        Dashboard dashboard = new Dashboard(driver);
        //oneplus neckband
        dashboard.searchText("oneplus neckband z2");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");

        dashboard.setAmountByFilter("2500","3500");
        js.executeScript("window.scrollBy(0,2000)");
    }
}
