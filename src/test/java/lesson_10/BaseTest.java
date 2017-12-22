package lesson_10;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    static WebDriver webDriver;
    private static String BASE_URL = "http://automationpractice.com/index.php";

    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }
    };

    private void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot)webDriver)
                .getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("report.path") + "/screenshots/" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
            LOG.info("Screenshot was got: " + screenshot.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();

    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
