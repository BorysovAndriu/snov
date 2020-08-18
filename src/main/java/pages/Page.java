package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }



    public static void clickOnElementByJS(WebElement element, String nameElement, WebDriver driver){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch (TimeoutException var){
            //log.info(nameElement +" isn't clickable");
        }

        try{
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            //log.info("Click on " + nameElement);
        }catch (NoSuchElementException var){
            //log.error(nameElement+" was not found on page long time");
        }catch (ElementClickInterceptedException var){
            //log.error(nameElement+ " is not clickable at point");
        }

    }


}
