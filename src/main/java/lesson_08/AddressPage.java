package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage{
    WebDriver webDriver;

    AddressPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(name = "processAddress")
    WebElement proceed_button;

    ShippingPage proceed(){
        LOG.info("Proceed to shipping page");
        proceed_button.click();
        return new ShippingPage(getWebDriver());
    }
}
