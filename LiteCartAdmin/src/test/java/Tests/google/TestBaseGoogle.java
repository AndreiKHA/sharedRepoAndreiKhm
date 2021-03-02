package Tests.google;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBaseGoogle {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void init(){
        if(tlDriver.get() != null){
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 3);
            return;
        }
/*      ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);*/
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 3);
        //System.out.println(((HasCapabilities)driver).getCapabilities());

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null;}));

    }

    @AfterClass
    public void stop(){
        //driver.quit();
    }

    public boolean isElementPresent (By locator){
        try {
                driver.findElement(locator);
                return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
