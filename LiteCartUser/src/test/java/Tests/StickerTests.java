package Tests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StickerTests extends TestBase {

    @Test
    public void stickersPresenceTest() {
        List<WebElement> productsList = app.driver.findElements(By.name(".product-column"));
        for(WebElement we: productsList) {
            System.out.println(we.getAttribute("innerHtml"));
            Assert.assertTrue(app.driver.findElement(By.cssSelector(".sticker.sale"))!= null || app.driver.findElement(By.cssSelector(".sticker.new"))!= null);
        }
    }
}
