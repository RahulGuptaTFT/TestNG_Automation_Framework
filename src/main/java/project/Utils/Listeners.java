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
import project.basetest.BaseTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test case Start and TestCase name is = " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test case Success and TestCase name is = " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("test case Failed and TestCase name is = " + result.getName());

        WebDriver driver = BaseTest.getDriver();
        byte[] failedSS = takeScreenshot(driver);
        Allure.addAttachment(UUID.randomUUID().toString(),new ByteArrayInputStream(failedSS));
        saveLogs(result.getMethod().getMethodName());
        saveLogs("cart count is not right");
    }

    //    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLogs(String msg) {
        return msg;
    }
}
