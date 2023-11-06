package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Review {
    WebDriver driver;
    public Review(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Write a product review']")
    WebElement review;
    @FindBy(xpath = "//form/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[5]/img[1]")
    WebElement star_5;
    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='react-app']/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/label[1]/i[1]")
    WebElement fitAsExpected;
    @FindBy(xpath = "//input[@id='scarface-review-title-label']")
    WebElement headline;
    @FindBy(xpath="//textarea[@id='scarface-review-text-card-title']")
    WebElement textarea;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submit;

    public void addReview(String Headline , String TextArea){
        review.click();
        star_5.click();
        fitAsExpected.click();
        headline.sendKeys(Headline);
        textarea.sendKeys(TextArea);
        submit.click();
    }
}
