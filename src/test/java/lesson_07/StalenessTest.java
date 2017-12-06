package lesson_07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StalenessTest {
    public static WebDriver webDriver;
    public static String BASE_URL = "http://automationpractice.com/";

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @Test
    public void test01_Staleness(){
        webDriver.findElement(By.name("search_query")).sendKeys("dress");
        webDriver.findElement(By.name("search_query")).submit();

        By locator = By.cssSelector("li[id=\"grid\"][class=\"selected\"]");

        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        webDriver.findElement(By.className("icon-th-list")).click();
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.stalenessOfElement(locator));

    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}
