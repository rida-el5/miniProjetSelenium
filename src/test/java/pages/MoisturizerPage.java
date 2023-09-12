package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilityFonctions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MoisturizerPage extends UtilityFonctions{
    @FindBy(xpath = "//h2[normalize-space()='Moisturizers']")
    private WebElement pageName;

    @FindBy(xpath = "//div[contains(@class, 'row justify-content-center top-space-50')]/div[contains(@class, 'text-center col-4')]/p[contains(@class, 'font-weight-bold top-space-10')]")
    private List<WebElement> productsTitles = new ArrayList<>();

    @FindBy(xpath = "//div[contains(@class, 'row justify-content-center top-space-50')]/div[contains(@class, 'text-center col-4')]/p[2]")
    private List<WebElement> productsPrices = new ArrayList<>();

    @FindBy(xpath = "//div[contains(@class, 'row justify-content-center top-space-50')][1]/div[1]/button[1]")
    private WebElement firstAddProduct;

    public WebElement getPageName() {
        return pageName;
    }

    WebDriver driver;

    public MoisturizerPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkTitleAndPrice(){
        if(productsTitles.isEmpty())
            System.out.println("No titles exist");
        else {
            var titles = productsTitles.stream().map(o -> o.getText()).collect(Collectors.toList());
            for (String title : titles){
                if (title.isEmpty() || title == null)
                    System.out.println("title missing");
                else
                    System.out.println(productsTitles);
            }
            System.out.println("all titles presents : " + productsTitles.stream().map(o -> o.getText()).collect(Collectors.toList()));
        }
        if(productsPrices.isEmpty())
            System.out.println("No prices exist");
        else {
            Pattern pattern = Pattern.compile("\\d+");

            List<Integer> pricesList = productsPrices.stream()
                    .map(input -> {
                        Matcher matcher = pattern.matcher(input.getText());
                        StringBuilder result = new StringBuilder();
                        while (matcher.find()) {
                            result.append(matcher.group());
                        }
                        return result.toString();
                    })
                    .filter(str -> !str.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            boolean allNumbersPresent = pricesList.stream()
                    .allMatch(pricesList::contains);
            if (allNumbersPresent)
                System.out.println("All prices present :" + productsPrices.stream().map(o -> o.getText()).collect(Collectors.toList()));
            else
                System.out.println("A price is missing");
        }
    }

    public void addFirstProduct(){
        firstAddProduct.click();
    }

    private String getXPathWithoutUnwantedPart() {
        try {
            Field field = this.getClass().getDeclaredField("firstAddProduct");
            FindBy findBy = field.getAnnotation(FindBy.class);
            if (findBy != null) {
                String fullXpath = findBy.xpath();
                // Remove the unwanted part
                String xpathWithoutUnwantedPart = fullXpath.replace("/button[1]", "");
                return xpathWithoutUnwantedPart;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void checkProductMatching() throws InterruptedException {
        var firstProduct = getXPathWithoutUnwantedPart();
        driver.navigate().back();
        var title = driver.findElement(By.xpath(firstProduct + "/p[1]")).getText();
        var price = driver.findElement(By.xpath(firstProduct + "/p[2]")).getText();
        Thread.sleep(1000);
        driver.navigate().forward();
        var actualTitle = driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
        var actualPrice = driver.findElement(By.cssSelector("tbody tr td:nth-child(2)")).getText();
        UtilityFonctions utilityFonctions = new UtilityFonctions();
        utilityFonctions.assertEquals(title, actualTitle);
        utilityFonctions.assertEquals(extractPrice(price), actualPrice);
    }

    private String extractPrice(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public void checkCurrentPage(){
        assertEquals("Moisturizers", this.getPageName().getText());
    }
}
