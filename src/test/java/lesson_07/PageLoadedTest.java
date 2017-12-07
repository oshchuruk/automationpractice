package lesson_07;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageLoadedTest {
    public static WebDriver webDriver = ConditionsTestSuite.getWebDriver();

    @Test
    public void test01_TitleUrl(){
        (new WebDriverWait(webDriver, 10)).until(CustomConditions.pageIsLoaded("My Store", "/index.php"));
    }

}
