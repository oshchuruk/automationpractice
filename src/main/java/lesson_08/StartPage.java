package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {
    WebDriver webDriver;

    StartPage(WebDriver webDriver){
        super(webDriver);
    }
}
