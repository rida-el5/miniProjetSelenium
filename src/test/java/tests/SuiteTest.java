package tests;

import configuration.ChromeConfiguration;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MoisturizerPage;
import pages.ShoppingCart;
import util.UtilityFonctions;

public class SuiteTest extends ChromeConfiguration {

    @Test(priority = 1)
    public void casTestUn() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        MoisturizerPage moisturizerPage = new MoisturizerPage(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        homePage.checkCurrentPage();
        homePage.clickBuyMoisturizer();
        moisturizerPage.checkCurrentPage();
        moisturizerPage.checkTitleAndPrice();
        moisturizerPage.addFirstProduct();
        shoppingCart.checkShoppingCart();
        shoppingCart.clickOnShoppingCart();
        moisturizerPage.checkProductMatching();
        shoppingCart.clickPayWithCart();
        shoppingCart.checkPopup();
    }

    /*@Test(priority = 2)
    public void casTestDeux(){
        System.out.println("cas test 2 passed!");
    }*/
}
