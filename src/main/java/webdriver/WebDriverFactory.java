package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    private static WebDriver webDriver;

    private WebDriverFactory () {

    }

    public static WebDriver getInstance(String browser) {
        if (webDriver == null) {
            if (CHROME.equals(browser)) {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("disable-infobars");

                webDriver = new ChromeDriver(options);

            } else if (FIREFOX.equals(browser)) {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("marionette", false);

                webDriver = new FirefoxDriver(firefoxOptions);

            } else
                throw new IllegalArgumentException("Invalid browser property set in configuration file");

            webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }


    public static void killDriverInstance() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

