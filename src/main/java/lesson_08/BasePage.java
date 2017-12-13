package lesson_08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class BasePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public BasePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    WebDriver getWebDriver(){
        return webDriver;
    }

    protected final Logger LOG = LogManager.getLogger(this);

    @FindBy(css = "input[id=\"search_query_top\"]")
    WebElement search_field;

    @FindBy(css = "a[title=\"View my shopping cart\"]")
    WebElement cart;

    SearchPage search(String search_value){
        wait.until(ExpectedConditions.visibilityOf(search_field));
        LOG.info("Searching for - " + search_value);
        search_field.sendKeys(search_value);
        search_field.submit();

        return new SearchPage(webDriver);
    }

    CartPage navigateToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        LOG.info("Navigating to cart");
        cart.click();
        return new CartPage(getWebDriver());
    }

    AccountPage navigateToAccount(){
        By account_locator = By.className("account");
        wait.until(ExpectedConditions.elementToBeClickable(account_locator));
        LOG.info("Navigating to my account");
        webDriver.findElement(account_locator).click();
        return new AccountPage(getWebDriver());
    }

    LoginPage navigateToLogin(){
        By login_locator = By.cssSelector("a[class=\"login\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(login_locator));
        LOG.info("Navigating to login");
        webDriver.findElement(login_locator).click();
        return new LoginPage(getWebDriver());
    }
}
