package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends BasePage{

    WebDriver webDriver;

    ShippingPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(name = "processCarrier")
    WebElement proceed_button;

    @FindBy(id = "cgv")
    WebElement terms_of_service;

    PaymentPage proceed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("carrier_title")));
        LOG.info("Agree with terms of service");
        terms_of_service.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(terms_of_service, true));
        wait.until(ExpectedConditions.elementToBeClickable(proceed_button));
        LOG.info("Proceed to payment page");
        proceed_button.click();
        return new PaymentPage(getWebDriver());
    }
}
