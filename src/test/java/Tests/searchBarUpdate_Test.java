package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.Pages.Dashboard;
import project.Pages.Homepage;
import project.Pages.LoginPage;
import project.Utils.propertiesFile;
import project.basetest.BaseTest;

public class searchBarUpdate_Test extends BaseTest {
    propertiesFile prop = new propertiesFile();
    String id = prop.getId();
    String pass = prop.getPass();

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


}
