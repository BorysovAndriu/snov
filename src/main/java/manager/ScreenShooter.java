package manager;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShooter {

    public static void sendScreen (WebDriver driver) {
        byte[] screenshotAs = ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.BYTES);
        saveScreenshot(screenshotAs);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
