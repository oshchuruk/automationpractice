package lesson_05;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SearchTest {

    private static WebDriver webDriver = FirstTestSuite.getWebDriver();


    @Test
    public void test01_search(){
        webDriver.findElement(By.name("search_query")).sendKeys("Printed Summer Dress");
        webDriver.findElement(By.name("search_query")).submit();
        Assert.assertTrue(webDriver.findElement(By.className("product-count")).getText().contains(" 3 items"));
        //ArrayList<WebElement> found_elements = new ArrayList<>(webDriver.findElements(By.cssSelector("ul[class=\"product_list grid row\"] a[class = \"product-name\"] ")));
        By found_elements_locator = By.cssSelector("ul[class=\"product_list grid row\"] > li");
        ArrayList<WebElement> found_elements = new ArrayList<>(webDriver.findElements(found_elements_locator));
        (new WebDriverWait(webDriver, 10)).until(lesson_07.CustomConditions.listLenghtToBe(found_elements_locator,3));
        Assert.assertTrue(found_elements.get(0).getText().contains("Printed Summer Dress"));
    }

}
