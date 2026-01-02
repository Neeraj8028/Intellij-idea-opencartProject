package pageObjects;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import testBase.BaseClass;

public class LoginPage extends BasePage {

//    constructor

    public LoginPage(WebDriver driver){
        super(driver);
    }

//    locators


    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement emailPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement LoginBTN;


//    Action methods

    public void setEmail(String email){
        emailInput.sendKeys(email);
    }

    public void setPassword(String pwd){
        emailPassword.sendKeys(pwd);
    }

    public void clickLogin(){
        LoginBTN.click();
    }

}
