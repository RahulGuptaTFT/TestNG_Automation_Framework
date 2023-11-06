package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;
    @FindBy(id = "nav-search-submit-button")
    WebElement Enter_to_Search;
    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]")
    WebElement oneplusNeckband;
    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]/span[1]")
    WebElement fastTrackWatch;
    @FindBy(xpath = "//span[contains(text(),'Mens Court Vision Mid Nn Sneaker')]")
    WebElement NikeShoes;
    @FindBy(xpath = "//span[text()='Apple iPhone 13 (128GB) - Green']")
    WebElement iphone;
    @FindBy(xpath = "//div[@id='HLCXComparisonWidget_feature_div']")
    WebElement compare;
    @FindBy(xpath = "//input[@id='low-price']")
    WebElement minPrice;
    @FindBy(xpath = "//input[@id='high-price']")
    WebElement maxPrice;
    @FindBy(xpath = "//form/span[3]/span[1]/input[1]")
    WebElement goButton;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void searchText(String s) {
        searchBar.sendKeys(s);
        Enter_to_Search.click();
    }

    public void clearTextFromSearchBar() {
        searchBar.clear();
    }

    public String getSearchBarText() {
        return searchBar.getAttribute("value");
    }

    public void clickOnePlusNeckband() {
        oneplusNeckband.click();
    }

    public void clickFastTrackWatch() {
        fastTrackWatch.click();
    }

    public void clickNikeShoes() {
        NikeShoes.click();
    }

    public void clickIphone13(){
        iphone.click();
    }
    public boolean checkCompareIsDisplayed(){
        return compare.isDisplayed();
    }
    public void setAmountByFilter(String min,String max){
        minPrice.sendKeys(min);
        maxPrice.sendKeys(max);
        goButton.submit();
    }
}
