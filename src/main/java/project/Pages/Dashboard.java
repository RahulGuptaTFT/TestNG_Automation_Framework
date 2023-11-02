package project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;
    @FindBy(id = "nav-search-submit-button")
    WebElement Enter_to_Search;
    @FindBy(xpath = "//span[text()='Apple iPhone 13 (128GB) - Green']")
    WebElement iphone13_Green;
    @FindBy(xpath = "//span[text()='Apple iPhone 13 (128GB) - Midnight']")
    WebElement iphone13_Midnight;
    @FindBy(xpath = "//span[text()='Apple iPhone 13 (128GB) - Starlight']")
    WebElement iphone13_Startlight;



    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void searchText(String s) {
        searchBar.sendKeys(s);
        Enter_to_Search.click();
    }

    public String getSearchBarText() {
        return searchBar.getAttribute("value");
    }

    public void clickIphone13_Green() {
        iphone13_Green.click();
    }

    public void clickIphone13_Midnight() {
        iphone13_Midnight.click();
    }

    public void clickIphone13_Starlight() {
        iphone13_Startlight.click();
    }


}
