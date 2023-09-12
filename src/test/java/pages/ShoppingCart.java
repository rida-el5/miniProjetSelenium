package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilityFonctions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShoppingCart extends UtilityFonctions{
    @FindBy(xpath = "//button[@class='thin-text nav-link']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//span[normalize-space()='Pay with Card']")
    private WebElement payWithCart;

    public WebElement getPopupName() {
        return popupName;
    }

    @FindBy(xpath = "//div[@class = 'title']/h1")
    private WebElement popupName;

    WebDriver driver;

    public ShoppingCart (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkShoppingCart(){
        UtilityFonctions utilityFonctions = new UtilityFonctions();
        utilityFonctions.assertEquals(true, shoppingCart.getText().contains("1"));
    }

    public void clickOnShoppingCart(){
        shoppingCart.click();
    }

    public void clickPayWithCart(){
        payWithCart.click();
    }

    public void checkPopup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.switchTo().frame(0);
        assertEquals("Stripe.com", ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", popupName));
        driver.switchTo().defaultContent();
    }
}
