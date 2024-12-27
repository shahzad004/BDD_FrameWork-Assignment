package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

import pages.flipkart.AddingItemtoCart;
import pages.flipkart.RemoveItemFromCart;
import pages.flipkart.SearchFeature;
import utils.WaitUtils;

public class GoogleTest extends BaseTest {


    @Test
    public void SearchFeatureTest() throws InterruptedException {
        SearchFeature searchFeature=new SearchFeature(driver);
        WaitUtils.globalWait();

        searchFeature.searchForItem("Mobile Feature");


    }


    @Test
    public void addItemCart() throws InterruptedException {
        AddingItemtoCart addingItemtoCart=new AddingItemtoCart(driver);

        WaitUtils.globalWait();

        addingItemtoCart.additionToCart();
        Thread.sleep(5000);


    }




    }