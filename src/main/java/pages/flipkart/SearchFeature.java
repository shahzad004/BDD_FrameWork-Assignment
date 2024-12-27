package pages.flipkart;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class SearchFeature {


   public WebDriver driver;

   public SearchFeature(WebDriver driver){
      this.driver= driver;
      PageFactory.initElements(driver, this);
   }

   @FindBy (xpath = "//input[@placeholder='Search for Products, Brands and More']")
    public WebElement searchBar;

   @FindBy(xpath = "//button[@title='Search for Products, Brands and More']//*[name()='svg']")
   public WebElement searchButton;

   public void searchForItem(String item) throws InterruptedException {
      WaitUtils.applyWait(driver,searchBar, WaitStrategy.VISIBLE);
      searchBar.sendKeys(item);
      searchButton.click();
      Thread.sleep(10000);

   }

}
