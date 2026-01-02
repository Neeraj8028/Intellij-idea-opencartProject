package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.security.PublicKey;

public class MyAccountPage extends  BasePage{
    private static final Logger log = LoggerFactory.getLogger(MyAccountPage.class);

//    Constructor

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

//    Locators
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement confirmationMSG;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logout;
//    Action Methods

    public boolean isMyAccountPageExist() {
        try {
            return confirmationMSG.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }

    public void clickLogout(){
        logout.click();
    }
}
