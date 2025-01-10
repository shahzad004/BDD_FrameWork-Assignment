package stepdefinations;
import Base.BaseTest;
import config.ConfigManager;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.flipkart.AddingItemtoCart;
import utils.WaitUtils;


public class AddingItemToCartStepdefinations extends BaseTest {


    private static final String baseUrl = ConfigManager.getProperty("baseUrl");
    private AddingItemtoCart cartPage;


    @Before
    public void setup() {

        cartPage = new AddingItemtoCart(driver);

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
        WaitUtils.applyWait(driver, cartPage.juicer, WaitStrategy.VISIBLE);
        cartPage.juicer.click();

        Thread.sleep(5000);
    }

    @When("I will click add to cart")
    public void i_will_click_add_to_cart() throws InterruptedException {
        WaitUtils.globalWait();

        Thread.sleep(15000);
        String text = cartPage.cartAdding.getText();
        if (text.equalsIgnoreCase("Add to Cart")) {
            cartPage.cartAdding.click();
        } else {
            cartPage.cartAdding.click();
            System.out.println("Add to Cart Option is not Available");
        }

        System.out.println("Item is Added to Cart");
        Thread.sleep(4000);
    }

    @After
    public void trDown() {
        System.out.println("SHut down");
        tearDown();
    }

}
