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
    public static String BASE_URL = "http://automationpractice.com/";

    AccountPage accountPage;
    LoginPage loginPage;
    SearchPage searchResultPage;
    StartPage startPage;
    ItemPage itemPage;
    CartPage cartPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    PaymentMethodPage bankwirePage;
    OrderHistoryPage orderHistoryPage;

    String email = "oshchuruk@gmail.com";
    String pass = "12345";
    static String TARGET_ITEM = "blouse";

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
        startPage = new StartPage(webDriver);
        loginPage = startPage.navigateToLogin();
        accountPage = loginPage.login(email, pass);
        searchResultPage = accountPage.search(TARGET_ITEM);
        searchResultPage.isItemFound(TARGET_ITEM);
        itemPage = searchResultPage.selectItem(TARGET_ITEM);
        itemPage.addItemToCart();
        cartPage = itemPage.navigateToCart();
        cartPage.neededItemInCart(TARGET_ITEM);
        addressPage = cartPage.proceed();
        shippingPage = addressPage.proceed();
        paymentPage = shippingPage.proceed();
        bankwirePage = paymentPage.payWithBankWire();
        bankwirePage.confirmOrder();
        accountPage = bankwirePage.navigateToAccount();
        orderHistoryPage = accountPage.navigateToOrderHistory();
        orderHistoryPage.getLastOrderInfo();
        orderHistoryPage.checkItemInOrder(TARGET_ITEM);
    }


    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }


}
