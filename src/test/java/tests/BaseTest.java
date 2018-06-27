package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
     AppiumDriver driver;

     @BeforeTest
     public void setup() throws MalformedURLException {
         DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("deviceName", "Samsung S5");
         caps.setCapability("udid", "72b39a50");
         caps.setCapability("platformName", "Android");
         caps.setCapability("platformVersion", "6.0.1");
//         caps.setCapability("deviceName", "HTC_Desire_610");
//         caps.setCapability("udid", "HT51FWS02326");
//         caps.setCapability("platformName", "Android");
//         caps.setCapability("platformVersion", "4.4.2");
         caps.setCapability("appPackage", "com.usemenu.MenuAndroidApplication");
         caps.setCapability("appActivity", "com.usemenu.MenuAndroidApplication.activities.SplashActivity");
         caps.setCapability("noReset", "true");
         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }

     @AfterTest
    public void tearDown(){
         driver.quit();
     }
}
