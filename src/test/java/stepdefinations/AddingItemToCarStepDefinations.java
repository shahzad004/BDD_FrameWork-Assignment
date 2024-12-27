package stepdefinations;

import Base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.flipkart.AddingItemtoCart;

public class AddingItemToCarStepDefinations extends BaseTest {

    public WebDriver driver;

    @Before
    public void featureSetup(){
        setup();
        this.driver=driver;
    }


    @Given("I am on wesbite")
    public void i_am_on_wesbite() {
        System.out.println("WE are on website");
        driver.switchTo().alert().dismiss();

    }
    @And("I will click on appliance")
    public void i_will_click_on_appliance() {
        AddingItemtoCart addingItemtoCart=new AddingItemtoCart(driver);

        addingItemtoCart.applicance.click();


    }
    @And("I will click on one item")
    public void i_will_click_on_one_item() throws InterruptedException {
        AddingItemtoCart addingItemtoCart=new AddingItemtoCart(driver);

        Thread.sleep(5000);
        addingItemtoCart.juicer.click();

    }
    @Then("I will click on Add to cart")
    public void i_will_click_on_add_to_cart() {

        AddingItemtoCart addingItemtoCart=new AddingItemtoCart(driver);




           addingItemtoCart.cartAdding.click();


        System.out.println("Item is Added to Cart");
    }

}
