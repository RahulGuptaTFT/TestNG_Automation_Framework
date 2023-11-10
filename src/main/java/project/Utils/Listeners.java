package project.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import project.WebdriverInitialize.initialize;
import project.basetest.BaseTest;

import java.io.File;
import java.io.IOException;


public class Listeners implements ITestListener {
    @Attachment(value = "Page Screenshot" , type = "image/png")
    public byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
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
        File file = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("C:/Users/Rahul Gupta/IdeaProjects/Test_Automation_Framework/Screenshots/"+result.getName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        saveScreenShot(initialize.getDriver());
    }
}
