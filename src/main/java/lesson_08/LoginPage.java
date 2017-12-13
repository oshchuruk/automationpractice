package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    WebDriver webDriver;

    LoginPage(WebDriver webDriver){
        super(webDriver);
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
        wait.until(ExpectedConditions.visibilityOf(email_field));
        email_field.sendKeys(username);
        return this;
    }

    LoginPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(pass_field));
        pass_field.sendKeys(password);
        return this;
    }

    void clickSignInBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(login_button));
        login_button.click();
    }

    AccountPage login(String username, String password){
        LOG.info("Logging user "+username);
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();

        return new AccountPage(getWebDriver());
    }
}
