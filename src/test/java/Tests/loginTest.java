package Tests;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.Pages.Homepage;
import project.Pages.LandingPage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;
@Listeners(project.Utils.Listeners.class)
public class loginTest extends BaseTest {

    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

    @Test(description = "Verifyuing Login Test")
    @Description("Verifyuing Login Test")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Story: Login into amazon")
    public void loginTest() {
        ExtentTest test = extent.createTest("Checking Login");
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
    }

}
