package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"regression","master"})
    void AccountRegisteration() throws InterruptedException {


        logger.info("******************   Starting TC001_AccountRegistrationTest ****************");

        try {
            HomePage HP = new HomePage(driver);
            HP.clickMyAccount();
            Thread.sleep(3000);
            HP.clicRegister();

            logger.info("******************  Started Registering ****************");

            AccountRegistration RP = new AccountRegistration(driver);
            RP.setFirstName(randomstrings());
            RP.setLastName(randomstrings());
            RP.setEmail( randomstrings()+ "S@gmail.com");  // Randomly generated email id
            RP.setPhoneNumber(randomNumber());

            String pwd = randomAlphaNumeric();
            RP.password(pwd);
            RP.confirmPassword(pwd);
            RP.clickCheckbox();
            RP.ClickContinueBTN();
            String msg = RP.getConfirmation();
            Assert.assertEquals(msg,"Your Account Has Been Created!");

        }catch (Exception e){
            logger.error("Test failed!!");
            logger.debug("Debug logs...");
        }

        logger.info("****************** Registration Completed ****************");

    }

}

