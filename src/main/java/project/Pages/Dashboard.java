package project.Pages;

import io.qameta.allure.Step;
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
    @FindBy(xpath = "//span[contains(text(),'AS-IT-IS ATOM Whey Protein 1kg with Digestive Enzymes')]")
    WebElement asitis;
    @FindBy(xpath = "//span[contains(text(),'Apple AirPods Pro')]")
    WebElement airpod;
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
    @Step("Clicking clear text from searchBar step")
    public void clearTextFromSearchBar() {
        searchBar.clear();
    }

    public String getSearchBarText() {
        return searchBar.getAttribute("value");
    }
    @Step("Clicking on asitis to add-to-cart step")
    public void clickAsitis() {
        asitis.click();
    }
    @Step("Clicking on airpods to add-to-cart step")
    public void clickAirpod() {
        airpod.click();
    }

    public void clickIphone13(){
        iphone.click();
    }
    @Step("comparing multiple products step")
    public boolean checkCompareIsDisplayed(){
        return compare.isDisplayed();
    }
    @Step("Set filter by amount step")
    public void setAmountByFilter(String min,String max){
        minPrice.sendKeys(min);
        maxPrice.sendKeys(max);
        goButton.submit();
    }
}
