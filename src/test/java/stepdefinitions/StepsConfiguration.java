package stepdefinitions;

import Constants.AppInformation;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class StepsConfiguration {
    public static ChromeDriver getDriver() {
        return driver;
    }

    private static ChromeDriver driver;

    public static AppInformation appInformation = new AppInformation();

    private static void setChromeDriver(){
        System.setProperty("webDriver.chromedriver.driver", "C:\\Users\\relmabro\\ws\\chromedriver.exe");
    }

    private static void navigateToUrl(String url){
        driver.get(url);
    }

    private static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Before
    public void setupDriver(){
        setChromeDriver();
        driver = new ChromeDriver();
        navigateToUrl(appInformation.getURL());
        maximizeWindow();
    }
}
