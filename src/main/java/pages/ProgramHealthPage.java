package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverFactory;

public class ProgramHealthPage {

    private WebDriverFactory driver;

    private static String PAGE_URL="https://shop.eco-lavca.ua/programmy-zdorovya-all/";

    @FindBy(xpath = "//*[@id=\"menu-osnovnoe-1\"]/li[2]")
    private WebElement shopMenu;

    public ProgramHealthPage (WebDriverFactory driver) {
        this.driver=driver;
        driver.getInstance("chrome");
        WebDriverFactory.LoadApplication(PAGE_URL);
    }
}
