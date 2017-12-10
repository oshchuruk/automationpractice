package lesson_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver webDriver;

    SearchPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(className = "icon-th-list")
    WebElement switch_to_list_view_button;

    @FindBy(className = "heading-counter")
    WebElement heading_counter;

    int count_of_results = Character.getNumericValue(heading_counter.getText().charAt(0));

    List<WebElement> search_result = webDriver.findElements(By.cssSelector("div[class=\"product-container\"] a[class=\"product-name\"]"));

    List<WebElement> buttons_list = webDriver.findElements(By.cssSelector("div[class=\"product-container\"] a[class*=\"add_to_cart_button\"]"));

    void switchToList(){
        switch_to_list_view_button.click();
    }





}
