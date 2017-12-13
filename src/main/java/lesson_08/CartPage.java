package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    WebDriver webDriver;

    CartPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy (css = "p[class=\"cart_navigation clearfix\"] a[title=\"Proceed to checkout\"]")
    WebElement proceed_button;

    @FindBy (css = "td p[class=\"product-name\"]")
    List<WebElement> items_in_cart;


    boolean neededItemInCart(String needed_item){
        LOG.info("Searching for "+needed_item+" in cart");
        for (WebElement item : items_in_cart){
            wait.until(ExpectedConditions.visibilityOf(item));
            if (item.getText().toLowerCase().equals(needed_item.toLowerCase())){
                LOG.info(needed_item+" is found");
                return true;
            }
        }
        LOG.info(needed_item+" is not found");
        return false;
    }

    AddressPage proceed(){
        LOG.info("Proceed to address page");
        wait.until(ExpectedConditions.elementToBeClickable(proceed_button));
        proceed_button.click();
        return new AddressPage(getWebDriver());
    }

}
