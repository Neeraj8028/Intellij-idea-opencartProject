package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{

//    Constructor
    public AccountRegistration(WebDriver driver){
        super(driver);
    }


//    Locators

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement FName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement LName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement MobileNO;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement cnfPassword;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement check;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueBTN;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement cnfMessage;


    public void setFirstName(String first_name){
        FName.sendKeys(first_name);
    }
    public void setLastName(String last_name){
        LName.sendKeys(last_name);
    }
    public void setEmail(String emaill){
        email.sendKeys(emaill);
    }
    public void setPhoneNumber(String phone_numer){
        MobileNO.sendKeys(phone_numer);
    }
    public void password(String pass){
        password.sendKeys(pass);
    }
    public void confirmPassword(String cnfPass){
        cnfPassword.sendKeys(cnfPass);
    }
    public void clickCheckbox(){
        check.click();
    }
    public void ClickContinueBTN(){
        continueBTN.click();
    }

    public String getConfirmation(){
        try {
            return (cnfMessage.getText());
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
