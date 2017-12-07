package lesson_07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        PageLoadedTest.class,
        NthElementTest.class,
        StalenessTest.class
        }
)

public class ConditionsTestSuite {
    private static String BASE_URL = "http://automationpractice.com/index.php";
    public static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        //webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }

}
