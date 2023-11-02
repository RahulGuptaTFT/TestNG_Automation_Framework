package project.basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent = new ExtentReports();
    protected static ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/reports/Extentreport.html");

    @BeforeTest
    public void beforeTest() {
        extent.attachReporter(spark);
    }


    @BeforeMethod
    @Parameters(value = {"browser", "url"})
    public void beforeMethod(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @AfterTest
    public void afterTest() {
        System.out.println("All tests Finished");
        extent.flush();
    }
}
