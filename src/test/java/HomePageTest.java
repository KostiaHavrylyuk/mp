import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShopPage;
import webdriver.WebDriverFactory;

public class HomePageTest {
    WebDriverFactory webDriver;

    @Test
    public void openShopPage() {
        HomePage home = new HomePage(webDriver);
        ShopPage shop = new ShopPage(webDriver);
        home.clickOnShopMenu();
        Assert.assertTrue(shop.isPageOpened());
    }
}
