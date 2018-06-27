package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUpPage;

import java.net.MalformedURLException;
import java.util.List;

public class SignUpTest extends BaseTest {

    SignUpPage sp;

    @BeforeTest
    public void setup() throws MalformedURLException {
        super.setup();
        sp = new SignUpPage(driver);
    }

    @Test
    public void testSignUpProcess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu")));

        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu")).click();
        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/buttonSignUp")).click();
        List<WebElement> textFields = driver.findElements(By.id("com.usemenu.MenuAndroidApplication:id/edittext"));

        textFields.get(0).sendKeys("Tester");
        textFields.get(1).sendKeys("Testeric");
        textFields.get(2).sendKeys("tester@gmail.com");
        textFields.get(3).sendKeys("tTesteric2018");

        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/continueButton")).click();

        List<WebElement> payment = driver.findElementsByClassName("android.widget.TextView");
        payment.get(3).click();

        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/cc_card")).sendKeys("9010100052000004 0221");
        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/cc_ccv")).sendKeys("118");
        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/signUpButton")).click();


        //Assert if customer is created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu")));
        driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu")).click();
        Assert.assertTrue(sp.isMenageAccountOptionVisible(), "Customer account not created successfully!");

    }



    @AfterTest
    public void tearDown() {
        super.tearDown();
    }
}
