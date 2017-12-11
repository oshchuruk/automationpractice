package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage{
    WebDriver webDriver;

    SearchPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(className = "icon-th-list")
    WebElement switch_to_list_view_button;

    @FindBy(className = "heading-counter")
    WebElement heading_counter;

    @FindBy(css = "div[class=\"product-container\"] a[class=\"product-name\"]")
    WebElement first_result;

    int count_of_results = Character.getNumericValue(heading_counter.getText().charAt(0));


    void switchToList(){
        switch_to_list_view_button.click();
    }

//    boolean isItemFound(String item_name){
//        for(WebElement item : search_result){
//            String temp_name = item.getText().toLowerCase();
//            if (temp_name.equals(item_name.toLowerCase())){
//                return true;
//            }
//        }
//        return false;
//    }

    ItemPage selectItem (String item_name){
//        List<WebElement> search_result = webDriver.findElements(By.cssSelector("div[class=\"product-container\"] a[class=\"product-name\"]"));
//        for(WebElement item : search_result){
//            String temp_name = item.getText().toLowerCase();
//            if (temp_name.equals(item_name.toLowerCase())){
//                item.click();
//                break;
//            }
//        }
        first_result.click();
        return new ItemPage(getWebDriver());
    }

}
