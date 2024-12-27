package pages.flipkart;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class RemoveItemFromCart {

    WebDriver driver;

    public RemoveItemFromCart(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);


    }


    @FindBy (xpath = "//a[normalize-space()='Cart']")
    public WebElement cart;

    @FindBy (xpath = "//div[normalize-space()='Remove']")
    public WebElement removeItem;

    public void removeItemFromCart() throws InterruptedException {

        WaitUtils.globalWait();
        cart.click();
        WaitUtils.applyWait(driver,removeItem, WaitStrategy.CLICKABLE);
        removeItem.click();

        driver.switchTo().alert().accept();

        Thread.sleep(5000);
    }

}
