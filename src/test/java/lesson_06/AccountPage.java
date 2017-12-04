package lesson_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver webDriver;

    AccountPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(className = "logout")
    public WebElement sign_out_link;

    @FindBy(className = "page-heading")
    public WebElement accountheading;

    LoginPage signOut(){
        sign_out_link.click();
        return new LoginPage(webDriver);
    }
}
