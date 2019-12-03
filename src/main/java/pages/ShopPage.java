package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverFactory;

public class ShopPage {

    private WebDriverFactory driver;

    private static String PAGE_URL="https://shop.eco-lavca.ua/shop/";

    @FindBy(xpath="//*[@class=\"shop-title-wrapper\"]")
    private WebElement header;

    public ShopPage () {
        this.driver=driver;
        driver.getInstance("chrome");
        WebDriverFactory.LoadApplication(PAGE_URL);
    }


    public boolean isPageOpened () {
        return header.isDisplayed();
    }

}
