package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
* Data valid -- login success -- test pass
* Data valid --- login fail -- test fail
*
* Data invalid --- login sucess --- test fail
* Data invalid ---- login fail --- test pass
* */
public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData" ,dataProviderClass= DataProviders.class , groups="DataDriven")
    public void verify_LoginDDT(String email, String pwd, String exp){

        logger.info("******************** Starting TC003_LoginTest **********************");



//    -------------------------------  page objects -------------------------------
        HomePage HP = new HomePage(driver);
        LoginPage LP = new LoginPage(driver);
        MyAccountPage AP = new MyAccountPage(driver);

        logger.info("********************Clicking My Account and Login  **********************");

//        Homepage
        HP.clickMyAccount();
        HP.clickLogin();

        logger.info("******************** Providing Login Credentials **********************");

//        Loginpage
        LP.setEmail(email);
        LP.setPassword(pwd);
        LP.clickLogin();

        logger.info("******************** Validating My Account Page **********************");

//        Account page
       boolean targetPage = AP.isMyAccountPageExist();

        if (exp.equalsIgnoreCase("valid")){
            if (targetPage == true){
                Assert.assertTrue(true);
                AP.clickLogout();
            }else {
                Assert.assertTrue(false);
            }
        }


        if (exp.equalsIgnoreCase("invalid")){
            if (targetPage == true){
                Assert.assertTrue(false);
            }else {
                Assert.assertTrue(true);
                AP.clickLogout();
            }
        }
        logger.info("******************** Finished TC003_LoginDDT  **********************");

    }

}
