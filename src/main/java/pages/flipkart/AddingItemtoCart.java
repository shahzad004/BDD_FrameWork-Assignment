package pages.flipkart;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AddingItemtoCart {

    public WebDriver driver;

    public AddingItemtoCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//img[@alt='Appliances']")
   public WebElement applicance;

    @FindBy (xpath = "(//img[@alt='wash'])[2]")
   public WebElement juicer;

    @FindBy (xpath = "//button[normalize-space()='Add to cart']")
    public WebElement cartAdding;

    public  void additionToCart() throws InterruptedException {
        applicance.click();
        WaitUtils.applyWait(driver,juicer, WaitStrategy.CLICKABLE);

        Thread.sleep(5000);
        juicer.click();

        WaitUtils.applyWait(driver,cartAdding,WaitStrategy.VISIBLE);
        Thread.sleep(5000);
         String text=cartAdding.getText();
        if(text.equalsIgnoreCase("Add to Cart"))
            cartAdding.click();
          else
            System.out.println("Add to Cart Option is not Available");
        System.out.println("Item is Added to Cart");

    }



}
