package stepdefinations;

import Base.BaseTest;
import config.ConfigManager;
import config.DriverFactory;
import enums.WaitStrategy;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import pages.flipkart.AddingItemtoCart;
import utils.WaitUtils;


public class AddingItemToCartStepdefinations extends BaseTest {


    public WebDriver driver;
    private static final String baseUrl= ConfigManager.getProperty("baseUrl");
    private AddingItemtoCart cartPage;


    @Before
    public void setup(){
        driver= DriverFactory.getDriver();
        cartPage=new AddingItemtoCart(driver);


    }

    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        System.out.println("Welcome");
        WaitUtils.globalWait();
    }
    @When("I will click on appliance")
    public void i_will_click_on_appliance() {
          cartPage.applicance.click();
    }
    @When("I will click on jucier")
    public void i_will_click_on_jucier() throws InterruptedException {
        WaitUtils.applyWait(driver,cartPage.juicer, WaitStrategy.VISIBLE);
        cartPage.juicer.click();

        Thread.sleep(5000);
    }

    @When("I will click add to cart")
    public void i_will_click_add_to_cart() throws InterruptedException {
        WaitUtils.globalWait();
        if(cartPage.cartAdding.getText().equalsIgnoreCase("Add to Cart")){


        cartPage.cartAdding.click();
        }
        else{
            System.out.println("There is no Option");
        }
        Thread.sleep(4000);
    }

}
