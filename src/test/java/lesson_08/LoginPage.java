package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver webDriver;

    LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(name = "email")
    private WebElement email_field;

    @FindBy(name = "passwd")
    private WebElement pass_field;

    @FindBy(name = "SubmitLogin")
    private WebElement login_button;

    @FindBy(className = "page-heading")
    public WebElement loginheading;

    LoginPage enterUsername(String username){
        email_field.sendKeys(username);
        return this;
    }

    LoginPage enterPassword(String password){
        pass_field.sendKeys(password);
        return this;
    }

    void clickSignInBtn(){
        login_button.click();
    }

    AccountPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();

        return new AccountPage(webDriver);
    }
}
