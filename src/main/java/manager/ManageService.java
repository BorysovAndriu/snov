package manager;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageService {

    @Step("Open {url}")
    public static void getDirectlyUrl(String url, WebDriver driver){
        try{
            driver.get(url);
        }
        catch (TimeoutException var){
            System.out.println("Page wasn't open");
        }
    }

    @Step("Verify that condition is true")
    public static void assertTrue(Boolean condition, String errorMessage){
        Assert.assertTrue(condition);
    }

    @Step("Verify that conditions are equals")
    public static <T> void assertEquals( T condition1, T condition2, String errorMessage){
        Assert.assertEquals(condition1, condition2);
    }
}
