package utils;

import config.ConfigManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static Duration getTimeout(){
        String timeoutValue= ConfigManager.getProperty("timeout");
        int timeoutInSeconds= (timeoutValue!= null)?
                Integer.parseInt(timeoutValue): 10 ;

        return Duration.ofSeconds(timeoutInSeconds);
    }


    public static void globalWait(){

        boolean isWaitEnable= Boolean.parseBoolean(ConfigManager.getProperty("EnableWait"));

        int waitInSeconds= Integer.parseInt(ConfigManager.getProperty("waitInSeconds"));
        if(isWaitEnable && waitInSeconds>0){

            try{
                Thread.sleep(waitInSeconds * 1000L);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static WebElement applyWait(WebDriver driver, WebElement webElement, WaitStrategy waitStrategy){

        WebDriverWait waitTime= new WebDriverWait(driver, getTimeout());
        switch (waitStrategy){
            case CLICKABLE:
                return waitTime.until(ExpectedConditions.elementToBeClickable(webElement));

            case VISIBLE:
                return  waitTime.until(ExpectedConditions.visibilityOf(webElement));

            case NONE:

            default:
                return webElement;

        }

    }
    // method overriding

    public static WebElement applyWait(WebDriver driver, WebElement webElement, WaitStrategy waitStrategy, By element){

        WebDriverWait waitTime= new WebDriverWait(driver, getTimeout());
        switch (waitStrategy){
            case CLICKABLE:
                return waitTime.until(ExpectedConditions.elementToBeClickable(element));

            case PRESENCE:
                return  waitTime.until(ExpectedConditions.presenceOfElementLocated(element));


            case VISIBLE:
                return  waitTime.until(ExpectedConditions.visibilityOf(webElement));

            case NONE:

            default:
                return webElement;

        }

    }

}
