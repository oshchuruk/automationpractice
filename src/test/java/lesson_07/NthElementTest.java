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
public class NthElementTest {
    public static WebDriver webDriver;
    public static String BASE_URL = "http://automationpractice.com/";

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @Test
    public void test01_NthElement(){
        webDriver.findElement(By.name("search_query")).sendKeys("dress");
        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("ac_results")));
        List<WebElement> needed_list = webDriver.findElements(By.cssSelector("div[class = \"ac_results\"] li"));
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.listNthElementHasText(needed_list, 1, "Evening"));

    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}