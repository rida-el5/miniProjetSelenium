package configuration;

import Constants.AppInformation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.sql.Driver;

public class ChromeConfiguration {
    public static ChromeDriver driver;

    static AppInformation appInformation = new AppInformation();

    private static void setChromeDriver(){
        System.setProperty("webDriver.chromedriver.driver", "C:\\Users\\relmabro\\ws\\chromedriver.exe");
    }

    private static void navigateToUrl(String url){
        driver.get(url);
    }

    private static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @BeforeTest
    public static void setupDriver(){
        setChromeDriver();
        driver = new ChromeDriver();
        navigateToUrl(appInformation.getURL());
        maximizeWindow();
    }
}
