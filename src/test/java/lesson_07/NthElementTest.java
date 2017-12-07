package lesson_07;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NthElementTest {
    public static WebDriver webDriver = ConditionsTestSuite.getWebDriver();

    @Test
    public void test01_NthElement() {
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.pageIsLoaded("My Store", "/index.php"));
        webDriver.findElement(By.name("search_query")).clear();
        webDriver.findElement(By.name("search_query")).sendKeys("dress");
        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("ac_results")));
        List<WebElement> needed_list = webDriver.findElements(By.cssSelector("div[class = \"ac_results\"] li"));
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.listNthElementHasText(needed_list, 1, "Evening"));
    }
}
