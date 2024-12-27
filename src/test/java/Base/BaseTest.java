package Base;

import config.ConfigManager;
import config.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class BaseTest {

    public WebDriver driver;
    public Logger logger= LogManager.getLogger(BaseTest.class);
    private static final String baseUrl= ConfigManager.getProperty("baseUrl");



    @BeforeMethod
    public void setup(){

        driver=DriverFactory.getDriver();
        driver.get(baseUrl);
        System.out.println(baseUrl);
    }

    @AfterMethod
    public void tearDown(){

      DriverFactory.quitDriver();
        }


}
