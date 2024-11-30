package tests;

import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.AssertJUnit.assertTrue;

public class ProductsTest extends BaseTest {


    @Test
    public void addGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart("Sauce Labs Backpack");
//        productsPage.addToCart("Sauce Labs Bike Light");
//        productsPage.addToCart("Sauce Labs Fleece Jacket");
//        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart(1);
        productsPage.addToCart(2);
        productsPage.openCart();
        assertTrue(ProductsPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
