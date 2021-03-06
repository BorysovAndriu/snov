import org.testng.annotations.Test;
import pages.RegisterPage;

import static conf.Constants.BASE_URL;
import static conf.Constants.REGISTER;
import static manager.ManageService.*;
import static manager.ScreenShooter.sendScreen;
import static org.openqa.selenium.support.PageFactory.initElements;


public class Register_001_InvalidEmailTest extends TestBase{

    @Test(dataProviderClass = TestBase.class, dataProvider = "invalidEmail")
    public void test_001(String name, String email, String pass){

        getDirectlyUrl(BASE_URL + REGISTER, getDriver());

        //fill fields invalid data
        RegisterPage registerPage = initElements (getDriver(), RegisterPage.class);
        registerPage.fillRegisterFields(name,email,pass);

        //click sign up button
        registerPage.clickSignUpButton();

        //verify count error message
        assertTrue(registerPage.errorMessage.size()==1, "Error Message doesn't equals 1");

        //verify test error message
        assertEquals(registerPage.errorMessage.get(0).getText(), errorMessage.get("errorInvalidEmail"),
                "Text Error Message are different");

        //sent screen
        sendScreen(getDriver());
    }
}
