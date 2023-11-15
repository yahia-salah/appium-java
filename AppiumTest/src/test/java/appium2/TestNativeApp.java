package appium2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestNativeApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException, URISyntaxException {
        File f = new File("src/resources/ApiDemos-debug.apk");
        var apkFilePath = f.getAbsolutePath();

        System.out.println("APK File Path: "+apkFilePath);

        UiAutomator2Options options =new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setApp(apkFilePath);

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Text Entry dialog']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']")).clear();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']")).sendKeys("test");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/password_edit']")).clear();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/password_edit']")).sendKeys("12345");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
