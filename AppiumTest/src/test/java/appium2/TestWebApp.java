package appium2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class TestWebApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // before running this test, run the command appium --allow-insecure chromedriver_autodownload

        UiAutomator2Options options =new UiAutomator2Options()
                .setUdid("emulator-5554")
                .withBrowserName("Chrome");

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        driver.get("http://google.com");

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello Appium");

        Thread.sleep(2000);

        driver.quit();
    }
}
