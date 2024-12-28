package stepdefinations;

import Base.BaseTest;
import config.ConfigManager;
import config.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.flipkart.MobileMenu;

public class MobilefeatureStepDefinations extends BaseTest {

    public WebDriver driver;
    private static final String baseUrl= ConfigManager.getProperty("baseUrl");
   private MobileMenu cartPage;


    @Before
    public void brows(){
        driver=DriverFactory.getDriver();
        cartPage=new MobileMenu(driver);

    }


    @Given("I am on website")
    public void i_am_on_website(){
        System.out.println("Website");
    }

    @When("I will click on Mobile")
    public void i_will_click_on_mobile()  {


        cartPage.mobile.click();


    }


    @Then("I will click on offerZone")
    public void i_will_click_on_offerZone() {

        cartPage.offerZone.click();
    }




}
