import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CrossBrowser {

    private WebDriver driver;

    @BeforeTest
    @Parameters ("browser")
    public void setup (String browser) throws Exception {
        if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","C:/Downloads/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver","C:/Downloads/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testSearchAudi() {

        driver.get("https://auto.ria.com/uk/");
        WebElement element = driver.findElement(By.xpath("//input[@id=\"brandTooltipBrandAutocompleteInput-brand\"]"));
        element.sendKeys("Audi");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        boolean isDisplayed = driver.findElement(By.xpath("//div[@class=\"wrap\"]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Page with selected cars was not found");
        driver.close();
    }

}
