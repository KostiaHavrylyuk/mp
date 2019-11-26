package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverFactory;

public class HomePage {

    private WebDriverFactory driver;

    private static String PAGE_URL="https://shop.eco-lavca.ua/";

    @FindBy(xpath = "//*[@id=\"menu-osnovnoe-1\"]/li[1]")
    private WebElement shopMenu;

    public HomePage (WebDriverFactory driver) {
        this.driver=driver;
        driver.getInstance("chrome");
        WebDriverFactory.LoadApplication(PAGE_URL);
    }

    public void clickOnShopMenu () {
        shopMenu.click();
    }
}
