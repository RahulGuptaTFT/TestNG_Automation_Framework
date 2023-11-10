package project.basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import project.Pages.Homepage;
import project.Pages.LandingPage;
import project.WebdriverInitialize.initialize;

import java.time.Duration;


public class BaseTest {

   protected static WebDriver driver;
    protected static ExtentReports extent = new ExtentReports();
    protected static ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/reports/Extentreport.html");

    @BeforeTest
    public void beforeTest() {
        extent.attachReporter(spark);
    }

    @BeforeMethod
    @Parameters(value = {"browser","url"})
    public void beforeMethod(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        driver.quit();
    }
    @AfterTest
    public void afterTest() {
        System.out.println("All tests Finished");
        extent.flush();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
