package lesson_08;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BuyTest {
    public static WebDriver webDriver;
    public static String BASE_URL = "http://automationpractice.com/index.php?controller=my-account";

    AccountPage accountPage;
    LoginPage loginPage;
    SearchPage searchResultPage;

    String email = "oshchuruk@gmail.com";
    String pass = "12345";

    private void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(webDriver,5)).until(condition);
    }

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @Test
    public void test_Buy(){
        loginPage = new LoginPage(webDriver);
        accountPage = loginPage.login(email, pass);
        assertThat(textToBePresentInElement(accountPage.accountheading, "My account".toUpperCase()));

        searchResultPage = accountPage.search("printed summer dress");

    }


    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }


}
