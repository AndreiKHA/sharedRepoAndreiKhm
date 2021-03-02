package Tests.google;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTestOne extends TestBaseGoogle {

    @Test
    public void testOne(){
        String searchText = "First test search";
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertTrue(isElementPresent(By.id("rcnt")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xjs")));
        Assert.assertTrue(driver.getTitle().contains(searchText));
    }

    @Test
    public void testTwo(){
        String searchText = "Second test search";
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xjs")));
        Assert.assertTrue(driver.getTitle().contains(searchText));
    }

    @Test
    public void testThree(){
        String searchText = "Third test search";
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xjs")));
        Assert.assertTrue(driver.getTitle().contains(searchText));
    }


}
