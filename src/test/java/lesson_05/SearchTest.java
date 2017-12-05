package lesson_05;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SearchTest {
//    private static String BASE_URL = "http://automationpractice.com/index.php";
//    private static WebDriver webDriver = FirstTestSuite;
//
//    @BeforeClass
//    public static void setUp(){
//        webDriver = new FirefoxDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        webDriver.manage().window().maximize();
//        webDriver.get(BASE_URL);
//    }

    private static WebDriver webDriver = FirstTestSuite.getWebDriver();


    @Test
    public void test01_search(){
        webDriver.findElement(By.name("search_query")).sendKeys("Printed Summer Dress");
        webDriver.findElement(By.name("search_query")).submit();
        Assert.assertTrue(webDriver.findElement(By.className("product-count")).getText().contains(" 3 items"));
        //ArrayList<WebElement> found_elements = new ArrayList<>(webDriver.findElements(By.cssSelector("ul[class=\"product_list grid row\"] a[class = \"product-name\"] ")));
        ArrayList<WebElement> found_elements = new ArrayList<>(webDriver.findElements(By.cssSelector("ul[class=\"product_list grid row\"] > li")));
        Assert.assertEquals(3, found_elements.size());
        Assert.assertTrue(found_elements.get(0).getText().contains("Printed Summer Dress"));
    }

//    @AfterClass
//    public static void tearDown(){
//        webDriver.quit();
//    }
}
