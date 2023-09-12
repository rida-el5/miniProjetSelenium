package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilityFonctions;

public class HomePage extends UtilityFonctions {
    @FindBy(xpath = "//button[text()='Buy moisturizers']")
    WebElement buyMoisturizer;

    @FindBy(xpath = "//h2[normalize-space()='Current temperature']")
    private WebElement pageName;

    WebDriver driver;

    public WebElement getPageName() {
        return pageName;
    }

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBuyMoisturizer(){
        buyMoisturizer.click();
    }

    public void checkCurrentPage(){
        assertEquals("Current temperature", this.getPageName().getText());
    }
}
