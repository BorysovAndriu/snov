import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static conf.Constants.BASE_URL;
import static conf.Constants.REGISTER;
import static manager.ManageService.getDirectlyUrl;
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
        Assert.assertTrue(registerPage.errorMessage.size()==1);

        //verify test error message
        Assert.assertEquals(registerPage.errorMessage.get(0).getText(), errorMessage.get("errorInvalidEmail"));
    }
}
