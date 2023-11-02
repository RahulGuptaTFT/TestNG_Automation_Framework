package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

public class loginTest extends BaseTest {

    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

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

}
