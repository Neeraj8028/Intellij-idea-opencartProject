package testCases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"sanity","master"})
    public void verifyLogin(){

        logger.info("******************** Starting TC002_LoginTest **********************");

        HomePage HP = new HomePage(driver);
        LoginPage LP = new LoginPage(driver);
        MyAccountPage AP = new MyAccountPage(driver);

        logger.info("******************** Clicking on My Account **********************");
        HP.clickMyAccount();

        logger.info("******************** Clicking on Login **********************");
        HP.clickLogin();

        LP.setEmail(p.getProperty("email"));
        LP.setPassword(p.getProperty("password"));
        LP.clickLogin();

        logger.info("******************** Checking confirmation message **********************");

        AP.isMyAccountPageExist();
        HP.clickMyAccount();
        AP.clickLogout();

        logger.info("******************** Finished TC002_LoginTest **********************");
    }
}
