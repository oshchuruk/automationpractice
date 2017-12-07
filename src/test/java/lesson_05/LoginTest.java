package lesson_05;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
    private static WebDriver webDriver = FirstTestSuite.getWebDriver();

    public void openAccount(){
        webDriver.findElement(By.className("account")).click();
        Assert.assertEquals("My account".toUpperCase(), webDriver.findElement(By.className("page-heading")).getText());
    }

    public void checkPage(String selector_value, String heading_value){
        webDriver.findElement(By.cssSelector("a[title = \"" + selector_value + "\"]")).click();
        Assert.assertEquals(heading_value, webDriver.findElement(By.className("page-heading")).getText());
    }

    @Test
    public void test01_Login(){
        webDriver.findElement(By.className("login")).click();
        Assert.assertEquals("Authentication".toUpperCase(), webDriver.findElement(By.className("page-heading")).getText());
        webDriver.findElement(By.name("email")).sendKeys("oshchuruk@gmail.com");
        webDriver.findElement(By.name("passwd")).sendKeys("12345");
        webDriver.findElement(By.name("SubmitLogin")).click();
        Assert.assertEquals("My account".toUpperCase(), webDriver.findElement(By.className("page-heading")).getText());
    }

    @Test
    public void test02_Orders(){
        openAccount();
        checkPage("Orders", "Order history".toUpperCase());
    }

    @Test
    public void test03_Credit(){
        openAccount();
        checkPage("Credit slips", "Credit slips".toUpperCase());
    }

    @Test
    public void test04_Address(){
        openAccount();
        checkPage("Addresses", "My addresses".toUpperCase());
    }

    @Test
    public void test05_Wishlist(){
        openAccount();
        checkPage("My wishlists", "My wishlists".toUpperCase());
    }

    @Test
    public void test06_Info(){
        openAccount();
        webDriver.findElement(By.cssSelector("a[title = \"Information\"]")).click();
        Assert.assertEquals("Your personal information".toUpperCase(), webDriver.findElement(By.className("page-subheading")).getText());
    }

}
