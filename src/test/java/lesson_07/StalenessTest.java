package lesson_07;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StalenessTest {
    public static WebDriver webDriver = ConditionsTestSuite.getWebDriver();

    @Test
    public void test01_Staleness(){
        (new WebDriverWait(webDriver, 10)).until(lesson_07.CustomConditions.pageIsLoaded("My Store", "/index.php"));
        webDriver.findElement(By.name("search_query")).clear();
        webDriver.findElement(By.name("search_query")).sendKeys("dress");
        webDriver.findElement(By.name("search_query")).submit();
        (new WebDriverWait(webDriver, 10)).until(lesson_07.CustomConditions.pageIsLoaded("Search", "search"));

        By locator = By.cssSelector("li[id=\"grid\"][class=\"selected\"]");

        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        webDriver.findElement(By.className("icon-th-list")).click();
        (new WebDriverWait(webDriver, 10)).until(lesson_07.CustomConditions.stalenessOfElement(locator));
    }
}
