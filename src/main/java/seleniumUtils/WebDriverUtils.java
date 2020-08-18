package seleniumUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private WebDriver driver;

    public WebDriver getDriver(){

        //singleton
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            configure(driver);
        }
        return driver;
    }

    private void configure(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown(){
        try{
            driver.quit();
        }finally {
            driver=null;
        }
    }
}
