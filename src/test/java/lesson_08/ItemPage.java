package lesson_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage{
    WebDriver webDriver;

    ItemPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(name="Submit")
    WebElement submit_button;

    @FindBy(className = "cross")
    WebElement cross_button;

    void addItemToCart(){
        LOG.info("Adding selected item to cart");
        submit_button.click();
        wait.until(ExpectedConditions.elementToBeClickable(cross_button));
        cross_button.click();
    }

}
