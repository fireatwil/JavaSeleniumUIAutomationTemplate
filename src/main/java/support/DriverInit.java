package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class DriverInit {

    private String env = getProperty("env");
    private final String baseUrl = "http://spree-vapasi" + env + ".herokuapp.com/";
    private final String browser = getProperty("browser");
    public static WebDriver driver;

    public void getBrowser() {
        if (null == browser || browser.isEmpty()) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            this.driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        getBaseUrl();
    }

    private void getBaseUrl() {
        if(null == env || env.isEmpty()) {
            env = "";
        }
        this.driver.get(baseUrl);
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void closeBrowser() {
        this.driver.quit();
    }
}
