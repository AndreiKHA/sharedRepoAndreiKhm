package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestTwo extends TestBase {

    @Test
    public void loginTestOne(){
        app.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar")));
        Assert.assertTrue(app.driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void loginTestTwo(){
        app.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title = 'Logout']")));
        Assert.assertTrue(app.driver.findElement(By.id("platform")).getText().contains("2.2.7"));
    }

    @Test
    public void loginTestThree(){
        app.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar")));
        Assert.assertTrue(app.driver.getTitle().contains("Content"));
    }


}
