package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

//    constructor


    public HomePage(WebDriver driver){
        super(driver);
    }


//    locators
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement MyAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    WebElement Register;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement Login;
//    Action methods

    public  void clickMyAccount(){

        MyAccount.click();
    }

    public void clicRegister(){

        Register.click();
    }

    public void clickLogin(){
        Login.click();
    }
}
