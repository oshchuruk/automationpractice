package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage extends BasePage{
    WebDriver webDriver;

    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    void getLastOrderInfo(){
        webDriver.findElement(By.cssSelector("tr[class=\"first_item \"] a[class=\"color-myaccount\"]")).click();
    }

    boolean checkItemInOrder(String item_name){
        List<WebElement> items_in_order = webDriver.findElements(By.cssSelector("div[id=\"order-detail-content\"] tbody tr[class=\"item\"]  td[class=\"bold\"]"));
        for (WebElement item : items_in_order){
            if(item.getText().toLowerCase().contains(item_name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
