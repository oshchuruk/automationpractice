package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{
    WebDriver webDriver;

    CartPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy (css = "p[class=\"cart_navigation clearfix\"] a[title=\"Proceed to checkout\"]")
    WebElement proceed_button;

//    @FindBy (css = "td p[class=\"product-name\"]")
//    WebElement items_in_cart;
//
//
//    boolean neededItemInCart(String needed_item){
//        List<WebElement> items_in_cart = webDriver.findElements(By.cssSelector(""));
//
//        for (WebElement item : items_in_cart){
//            if (item.getText().toLowerCase().equals(needed_item.toLowerCase())){
//                return true;
//            }
//        }
//        return false;
//    }

    AddressPage proceed(){
        proceed_button.click();
        return new AddressPage(getWebDriver());
    }

}
