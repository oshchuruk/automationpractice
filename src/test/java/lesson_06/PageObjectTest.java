package lesson_06;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageObjectTest {
    public static WebDriver webDriver;
    public static String BASE_URL = "http://automationpractice.com/index.php?controller=my-account";

    AccountPage accountPage;
    LoginPage loginPage;

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
    public void test01_Login1(){
        loginPage = new LoginPage(webDriver);
        accountPage = loginPage.login(email, pass);
        assertThat(textToBePresentInElement(accountPage.accountheading, "My account".toUpperCase()));
    }

    @Ignore
    @Test
    public void test02_Login2(){
        loginPage = new LoginPage(webDriver);
        loginPage.enterUsername(email).enterPassword(pass).clickSignInBtn();
        accountPage = new AccountPage(webDriver);
        assertThat(textToBePresentInElement(accountPage.accountheading, "My account".toUpperCase()));
    }

    @Test
    public void test03_SignOut(){
        accountPage = new AccountPage(webDriver);
        loginPage = accountPage.signOut();
        assertThat(textToBePresentInElement(loginPage.loginheading, "Authentication".toUpperCase()));

    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }


}
