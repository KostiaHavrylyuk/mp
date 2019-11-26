import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingletonTest {


    @Test (groups = {"car", "volkswagen"})
    public static void testSearchVolkswagen() {

        Singleton firefox = Singleton.getInstanceOfSingleton();
        WebDriver firefoxDriver = firefox.getDriver();
        firefoxDriver.get("https://auto.ria.com/uk/");
        WebElement element = firefoxDriver.findElement(By.xpath("//input[@id=\"brandTooltipBrandAutocompleteInput-brand\"]"));
        element.sendKeys("Volkswagen");
        WebElement button = firefoxDriver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        boolean isDisplayed = firefoxDriver.findElement(By.xpath("//div[@class=\"wrap\"]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Page with selected cars was not found");
        firefoxDriver.close();
    }

    @Test (groups = {"car", "audi"})
    public static void testSearchAudi() {

        Singleton firefox = Singleton.getInstanceOfSingleton();
        WebDriver firefoxDriver = firefox.getDriver();
        firefoxDriver.get("https://auto.ria.com/uk/");
        WebElement element = firefoxDriver.findElement(By.xpath("//input[@id=\"brandTooltipBrandAutocompleteInput-brand\"]"));
        element.sendKeys("Audi");
        WebElement button = firefoxDriver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        boolean isDisplayed = firefoxDriver.findElement(By.xpath("//div[@class=\"wrap\"]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Page with selected cars was not found");
        firefoxDriver.close();
    }
}
