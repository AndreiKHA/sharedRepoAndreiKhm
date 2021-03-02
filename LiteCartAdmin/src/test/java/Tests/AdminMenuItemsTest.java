package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AdminMenuItemsTest extends TestBase {

    @Test
    public void clickAllItemsTest() throws InterruptedException {
        app.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#sidebar .app")));
        List<WebElement> listOfApps = app.driver.findElements(By.cssSelector("#sidebar .app"));

        for (int i = 1; i <= listOfApps.size(); i++) {
            WebElement application = app.driver.findElement(By.cssSelector("#sidebar .app:nth-child(" + i + ")"));
            application.click();
            Thread.sleep(500);
            System.out.println(app.driver.findElement(By.cssSelector(".panel-heading")).getText());

            List<WebElement> listOfSubApps = app.driver.findElements(By.cssSelector(".doc"));
            for (int j = 1; j <= listOfSubApps.size(); j++) {
                WebElement subApplication = app.driver.findElement(By.cssSelector(".doc:nth-child(" + j + ")"));
                subApplication.click();
                Thread.sleep(300);
                System.out.println(app.driver.findElement(By.cssSelector(".panel-heading")).getText());
            }

        }

    }
}


