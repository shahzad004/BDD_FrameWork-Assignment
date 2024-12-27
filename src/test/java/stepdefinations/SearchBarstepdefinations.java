package stepdefinations;

import Base.BaseTest;
import config.ConfigManager;
import config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import pages.flipkart.SearchFeature;
import utils.WaitUtils;

public class SearchBarstepdefinations extends BaseTest {

    public static String baseUrl=ConfigManager.getProperty("baseUrl");

    @Before
    public void featuresetup(){
            setup();

    }


    @Given("I am on flipkart")
    public void i_am_on_flipkart() {
        System.out.println("ON FLIPKART");



    }

    @And("I will click on search Bar")
    public void i_will_click_on_search_bar() throws InterruptedException {
        WaitUtils.globalWait();
        SearchFeature searchFeature=new SearchFeature(driver);
        WaitUtils.globalWait();

        searchFeature.searchBar.click();
    }

    @And("I will search for {string}")
    public void i_will_search_for(String string) throws InterruptedException {
        SearchFeature searchFeature=new SearchFeature(driver);
        WaitUtils.globalWait();
        searchFeature.searchForItem(string);

    }

    @Then("I will have Mobiles list")
    public void i_will_have_mobiles_list() {
        System.out.println("You made it");
    }

    @After
    public void tearDown(){
        super.tearDown();
    }



}
