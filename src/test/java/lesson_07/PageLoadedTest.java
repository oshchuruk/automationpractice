package lesson_07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageLoadedTest {
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
    public void test01_TitleUrl(){
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.pageIsLoaded("My Store", "/index.php"));
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}
