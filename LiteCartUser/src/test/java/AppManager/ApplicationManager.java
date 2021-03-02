package AppManager;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    private final Properties properties;
    public WebDriver driver;
    public WebDriverWait wait;
    public NavigationHelper navigationHelper;
    public SessionHelper sessionHelper;

    private String browser;
    public ApplicationManager(String browser){
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        if (driver != null) {
            return;
        }

        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver(caps);

        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver(caps);

        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver(caps);

        }

        System.out.println(((HasCapabilities)driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 2);
        driver.get(properties.getProperty("web.UserUrl"));

        sessionHelper = new SessionHelper(driver);
        //sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop(){
        driver.quit();
    }

    public NavigationHelper goTo(){
        return navigationHelper;
    }


}
