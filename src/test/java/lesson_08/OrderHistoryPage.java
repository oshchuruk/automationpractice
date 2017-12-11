package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage extends BasePage{
    WebDriver webDriver;

    @FindBy(css = "tr[class=\"first_item \"] a[class=\"color-myaccount\"]")
    WebElement last_order_info_button;

    @FindBy(css = "div[id=\"order-detail-content\"] tbody tr[class=\"item\"]  td[class=\"bold\"]")
    List<WebElement> items_in_order;

    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    void getLastOrderInfo(){
        last_order_info_button.click();
    }

    boolean checkItemInOrder(String item_name){
        for (WebElement item : items_in_order){
            if(item.getText().toLowerCase().contains(item_name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
