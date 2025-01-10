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

    @FindBy (xpath = "//div[4]//div[1]//div[1]//a[1]//div[1]//img[2] ")
   public WebElement juicer;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")

    public WebElement cartAdding;


    public  void additionToCart() throws InterruptedException {
        applicance.click();
        WaitUtils.applyWait(driver,juicer, WaitStrategy.CLICKABLE);

        Thread.sleep(3000);
        juicer.click();

        WaitUtils.applyWait(driver,cartAdding,WaitStrategy.VISIBLE);
        Thread.sleep(1000);
         String text=cartAdding.getText();
        if(text.equalsIgnoreCase("Add to Cart"))
            cartAdding.click();
          else

            System.out.println("Add to Cart Option is not Available");
        cartAdding.click();
        System.out.println("Item is Added to Cart");

    }



}
