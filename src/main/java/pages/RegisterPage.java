package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends Page{

    private WebDriver driver;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "buttonFormRegistration")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[contains(@class,'help-block')]")
    public List<WebElement> errorMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Fill register fields")
    public void fillRegisterFields (String name, String email, String password) {

        //Fill name
        nameField.sendKeys(name);
        //log.info("fill name " + email);

        //Fill email
        emailField.sendKeys(email);
        //log.info("fill email " + email);

        //Fill password
        passwordField.sendKeys(password);
        //log.info("fill password " + password);
    }

    @Step("Click Sign Up Button")
    public void clickSignUpButton(){

        //Click Sign Up button
        clickOnElementByJS(signUpButton, "Sign Up Button", driver);
    }

}
