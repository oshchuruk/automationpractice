package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentMethodPage extends BasePage{
    WebDriver webDriver;

    public PaymentMethodPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(css = "p[class=\"cart_navigation clearfix\"] button")
    WebElement confirm_button;

    @FindBy(css = "p[class=\"cheque-indent\"]")
    WebElement cheque;

    void confirmOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(confirm_button));
        LOG.info("Confirm order");
        confirm_button.click();
        wait.until(ExpectedConditions.visibilityOf(cheque));
        LOG.info("Checking complete order text");
        cheque.getText().contains("Your order on My Store is complete");
    }

}
