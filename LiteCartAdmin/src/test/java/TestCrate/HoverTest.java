package TestCrate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HoverTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Robot robot;

    @Test
    public void mouseHoverTest() throws InterruptedException, AWTException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        robot = new Robot();
        driver.get("https://www.crateandbarrel.com/");
        Thread.sleep(5000);
        driver.findElement(By.id("closeIconContainer")).click();
        Thread.sleep(1000);
/*        robot.mouseMove(100, 400);
        actions.click().build().perform();*/
/*      driver.switchTo().frame("overlayContainer").close();
        driver.findElement(By.id("closeIconContainer")).click();*/
/*        String subwindowhandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()){
            subwindowhandler = iterator.next();
        }

        driver.switchTo().window(subwindowhandler).close();*/

        WebElement we1 = driver.findElement(By.id("Nav_Furniture"));
        WebElement we2 = driver.findElement(By.id("Nav_Furniture_Living-Room-Furniture_Sectional-Sofas"));
        actions.moveToElement(we1).build().perform();
        actions.moveToElement(we2).build().perform();
    }


}
