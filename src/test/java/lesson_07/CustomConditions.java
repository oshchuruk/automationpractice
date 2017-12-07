package lesson_07;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.util.List;

public class CustomConditions {
    public static ExpectedCondition<Boolean> pageIsLoaded(String expected_title, String expected_url){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                Boolean title_result = webDriver.getTitle().contains(expected_title);
                Boolean url_result = webDriver.getCurrentUrl().contains(expected_url);
                return title_result && url_result;
            }
        };
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(List<WebElement> list, int index, String expected_text){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                try{
                    return list.get(index).getText().contains(expected_text);}
                catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> stalenessOfElement(By locator){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                List<WebElement> result = webDriver.findElements(locator);
                return result.isEmpty();
            }
        };
    }

    public static ExpectedCondition<Boolean> listLenghtToBe(By list_locator, int expected_size){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                List<WebElement> found_elements = webDriver.findElements(list_locator);
                Boolean result = found_elements.size() == expected_size;
                return result;
            }
        };
    }
}
