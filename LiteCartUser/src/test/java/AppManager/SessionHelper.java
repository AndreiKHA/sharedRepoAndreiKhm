package AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver){
        super(driver);
    }

    public void login(String username, String password){
        type(By.xpath("//input[@name = 'username']"), username);
        type(By.xpath("//input[@name = 'password']"), password);
        click(By.xpath("//button[@name = 'login']"));
    }

}
