package lesson_09;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JsTest {
    public static WebDriver webDriver;
    public static String BASE_URL = "http://automationpractice.com/";
    public static WebDriverWait wait;


    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
        wait = new WebDriverWait(webDriver, 5);
    }

    @Test
    public void test_Js(){
        wait.until(ExpectedConditions.titleIs("My Store"));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("document.getElementById(\"facebook_block\").scrollIntoView();");

        By iframe_locator = By.cssSelector("div[id=\"facebook_block\"] iframe");

        WebElement needed_iframe = webDriver.findElement(iframe_locator);
        webDriver.switchTo().frame(needed_iframe);

        By link_locator = By.cssSelector("div[class='lfloat'] a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(link_locator));
        Assert.assertTrue(webDriver.findElement(link_locator).getText().equals("PrestaShop"));

        webDriver.switchTo().defaultContent();

        By facebook_h4_locator = By.cssSelector("div[id=\"facebook_block\"] h4");

        wait.until(ExpectedConditions.visibilityOfElementLocated(facebook_h4_locator));
        Assert.assertTrue(webDriver.findElement(facebook_h4_locator).getText().equals("Follow us on Facebook"));
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}
