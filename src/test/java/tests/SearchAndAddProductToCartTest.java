package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class SearchAndAddProductToCartTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();

    @Test
    public void verifySearchAndClickOnProduct() {
        homePage.assertBrowserTitle();

    }
}