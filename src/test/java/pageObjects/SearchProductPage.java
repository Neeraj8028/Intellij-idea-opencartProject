package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProductPage extends BasePage{

//    Constructor

    public SearchProductPage(WebDriver driver){
        super(driver);
    }

//    Locators
    @FindBy(xpath="//input[@placeholder='Search']")WebElement SearchBox;
    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")WebElement SearchBtn;
    @FindBy(xpath="//div[@class='button-group']//button[@data-original-title='Add to Wish List']")WebElement AddToWishList;
    @FindBy(xpath="//h1[normalize-space()='Search - Product 8']")WebElement SearchResultText;
    @FindBy(css=".alert.alert-success.alert-dismissible")
    WebElement SuccessMsg;


//    Action Methods

    public void SearchProduct(String product) {
        SearchBox.sendKeys(product);
        SearchBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(AddToWishList));

        AddToWishList.click();
    }
    public String SearchResultText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(SearchResultText));
        return SearchResultText.getText();
    }

    public boolean ProductAddtionMessage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
        return SuccessMsg.isDisplayed();
    }
}
