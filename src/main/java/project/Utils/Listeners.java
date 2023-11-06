package project.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import project.basetest.BaseTest;

import java.io.File;

public class Listeners implements ITestListener{

    WebDriver driver;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test case Start and TestCase name is = "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test case Success and TestCase name is = "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test case Failed and TestCase name is = "+result.getName());
//        TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
//        File file = ts.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/screenshots/" + result.getName() + ".png"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
