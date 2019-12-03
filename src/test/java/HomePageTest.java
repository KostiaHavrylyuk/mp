import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.ShopPage;
import webdriver.WebDriverFactory;

public class HomePageTest extends BaseTest {

    @Test
    public void openShopPage() {
        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage();
        homePage.clickOnShopMenu();
        Assert.assertTrue(shopPage.isPageOpened());
    }
}
