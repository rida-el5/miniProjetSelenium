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

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='card_number']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@id='cc-exp']")
    private WebElement date;

    @FindBy(xpath = "//input[@id='cc-csc']")
    private WebElement cvv;

    @FindBy(xpath = "//span[@class='iconTick']")
    private WebElement payInner;

    @FindBy(xpath = "//p[@class='text-justify']")
    private WebElement confirmationMessage;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.switchTo().frame(0);
        assertEquals("Stripe.com", ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", popupName));
        driver.switchTo().defaultContent();
    }

    public void fillForm(String email, String cardNumber, String date, String cvv){
        driver.switchTo().frame(0);
        this.email.sendKeys(email);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = '"+ cardNumber +"';", this.cardNumber);
        jsExecutor.executeScript("arguments[0].value = '"+ date +"';", this.date);
        this.cvv.sendKeys(cvv);
        driver.switchTo().defaultContent();
    }

    public void clickPay(){
        driver.switchTo().frame(0);
        payInner.click();
        driver.switchTo().defaultContent();
    }

    public void checkConfirmationMessage(){
        assertEquals("Your payment was successful. You should receive a follow-up call from our sales team.", confirmationMessage.getText());
    }
}
