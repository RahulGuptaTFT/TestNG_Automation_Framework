package Tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.Pages.Homepage;
import project.basetest.BaseTest;

public class logoTest extends BaseTest {
    @Test(priority = 1)
    public void logotest() {
        ExtentTest test = extent.createTest("Checking Logo");
        test.pass("verified");
        Homepage homepage = new Homepage(driver);
        String s = homepage.getLogoText();
        Assert.assertEquals(s, ".in");
    }
}
