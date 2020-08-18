package manager;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

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
}
