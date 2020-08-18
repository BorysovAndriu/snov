import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import seleniumUtils.WebDriverUtils;

import java.util.Map;

import static manager.PropertyReader.getMap;
import static manager.ScreenShooter.sendScreen;

public abstract class TestBase extends WebDriverUtils{

    Map<String,String> errorMessage = getMap("src/main/resources/text.txt");

    @AfterMethod
    public void closeDriver() {
        sendScreen(getDriver());
        tearDown();
    }

    @DataProvider(name="invalidEmail")
    public static Object[][] invalidEmail(){
        return  new Object[][]{
                {"user_Name", "<script>alert(\"XSS\")</script>", "123456@#rer"},
                {"12#$%", "!@# . $ ^_ = %&(*", "wqwer!234"},
                {"1", "@cccc", "sdfdf sdfsdf"}
        };
    }
}
