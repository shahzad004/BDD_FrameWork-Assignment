package config;

import enums.Browser;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            intializeDriver();
        }
            return driver;

    }


    public static WebDriver intializeDriver(){

        Browser browser= Browser.valueOf(ConfigManager.getProperty("browser"));
        System.out.println("BROWSER IS: " +browser);



       boolean isHeadless= Boolean.parseBoolean(ConfigManager.getProperty("isHeadless"));

        System.out.println("IS HEADLESS MODE IS: "+ isHeadless );

        switch (browser){
            case CHROME :

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                if( isHeadless ){
                    chromeOptions.addArguments("--headless");
                }
                driver =new ChromeDriver(chromeOptions);
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                if(isHeadless){
                    edgeOptions.addArguments("--headless--");
                }
                driver=new EdgeDriver(edgeOptions);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();

                if(isHeadless){
                firefoxOptions.addArguments("--headless--");
                }
                driver=new FirefoxDriver(firefoxOptions);
                break;

            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                break;

            default:
                throw new RuntimeException("browser is failed");
        }

        driver.manage().window().maximize();
        return driver;






    }

    public  static void quitDriver(){
        if(driver != null){

            driver.quit();
            driver=null;

        }
    }






}
