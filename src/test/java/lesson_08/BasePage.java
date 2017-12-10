package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    WebDriver webDriver;

    @FindBy(name = "search_query")
    public WebElement search_field;

    SearchPage search(String search_value){
        search_field.sendKeys(search_value);
        search_field.submit();

        return new SearchPage(webDriver);
    }
}
