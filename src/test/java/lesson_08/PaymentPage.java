package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{
    WebDriver webDriver;

    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "bankwire")
    WebElement bankwire;

    PaymentMethodPage payWithBankWire(){
        LOG.info("Selecting bankwire payment method");
        bankwire.click();
        return new PaymentMethodPage(getWebDriver());
    }
}
