package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {


    public static WebDriver driver;   //   Webdriver
    public Logger logger; // log4j
    public Properties p;


    @Parameters({"os","browser"})

    @BeforeClass(groups = {"regression","sanity","master"})
    public void setup(String os, String br) throws IOException {


//        *************  Loading config.properties file *************************

        FileReader file = new FileReader("src/test/resources/config.properties");
        p = new Properties();
        p.load(file);


//        ******************   Log4j2   *******************
        logger = LogManager.getLogger(this.getClass());



//        ******************   Switching browser *****************

        switch (br.toLowerCase()){
            case "chrome": driver = new ChromeDriver();break;
            case "firefox": driver = new FirefoxDriver();break;
            case "edge": driver = new EdgeDriver();break;
            default: System.out.println("Invalid browser name"); return;
        }


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appURL"));   // READING APP URL FROM CONFIG FILE
        driver.manage().window().maximize();
    }


    @AfterClass(groups = {"regression","sanity","master"})
    public void tearDown(){
        driver.quit();
    }

    public  String randomstrings(){

        String randomString  = RandomStringUtils.randomAlphabetic(5);
        return randomString;
    }
    public String randomNumber(){
        String randomNum = RandomStringUtils.randomNumeric(10);
        return randomNum;
    }
    public String randomAlphaNumeric(){
        String generatedRandomString = RandomStringUtils.randomAlphabetic(3);
        String randomNum = RandomStringUtils.randomNumeric(10);
        return (generatedRandomString + "@"+randomNum);
    }
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format (new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
