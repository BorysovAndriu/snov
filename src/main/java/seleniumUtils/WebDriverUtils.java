package seleniumUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private RemoteWebDriver driver;

    public WebDriver getDriver(){

        //singleton
        if(driver==null){
            //WebDriverManager.chromedriver().setup();
            final DesiredCapabilities browser = DesiredCapabilities.chrome();
            browser.setCapability("enableVNC", true);
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.31.149:4444/wd/hub"), browser);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
