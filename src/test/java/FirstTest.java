import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    protected final static String BASE_URL = "https://github.com/";

    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
        webDriver = null;
    }
    @Ignore
    @Test
    public void gitHubShouldBeOpen(){
        Assert.assertTrue("Title should contain",webDriver.getTitle().contains("GitHub"));
    }

    @Test
    public void searchRepository(){
        WebElement input_field = webDriver.findElement(By.name("q"));
        input_field.click();
        input_field.sendKeys("maven");
        input_field.submit();
        WebElement res = webDriver.findElement(By.cssSelector("#js-pjax-container > div.container > div > div.column.three-fourths.codesearch-results.pr-6 > ul > div:nth-child(1) > div.col-8.pr-3 > h3 > a"));
        System.out.println(res.getText());
        Assert.assertTrue(res.getText().contains("maven"));
    }

}
