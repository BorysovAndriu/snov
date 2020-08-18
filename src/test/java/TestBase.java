import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import seleniumUtils.WebDriverUtils;

import java.util.Map;

import static manager.PropertyReader.getMap;
import static manager.ScreenShooter.sendScreen;

public abstract class TestBase extends WebDriverUtils{

    Map<String,String> errorMessage = getMap("src/main/resources/text.txt");

    @AfterMethod
    public void closeDriver() {
        tearDown();
    }

    @DataProvider(name="invalidEmail")
    public static Object[][] invalidEmail(){
        return  new Object[][]{
                {"Andriu", "<script>alert(\"XSS\")</script>", "1234567"},
                {"12#$%", "!@# . $ ^_ = %&(*", "wqwer!234"},
                {"1", "@cccc", "sdfdf sdfsdf"}
        };
    }
}
