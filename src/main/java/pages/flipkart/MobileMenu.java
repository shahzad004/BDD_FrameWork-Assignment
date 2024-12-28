package pages.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileMenu {

    WebDriver driver;
    public MobileMenu(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//img[@alt='Mobiles']")
    public WebElement mobile;

    @FindBy (xpath = "//a[normalize-space()='Offer Zone']")
    public WebElement offerZone;


}
