package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{
    WebDriver webDriver;

    AccountPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(className = "logout")
    public WebElement sign_out_link;

    @FindBy(className = "page-heading")
    public WebElement accountheading;

    OrderHistoryPage navigateToOrderHistory(){
        webDriver.findElement(By.cssSelector("a[title=\"Orders\"]")).click();
        return new OrderHistoryPage(getWebDriver());
    }


    LoginPage signOut(){
        sign_out_link.click();
        return new LoginPage(getWebDriver());
    }
}
