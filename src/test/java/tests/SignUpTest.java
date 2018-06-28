package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUpPage;

import java.net.MalformedURLException;

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

        sp.getHamburgerMenu().click();
        sp.getSignUpLink().click();

        sp.getAllTextFields().get(0).sendKeys("MenuTester");
        sp.getAllTextFields().get(1).sendKeys("MenuTesteric");
        sp.getAllTextFields().get(2).sendKeys("tester@menu.com");
        sp.getAllTextFields().get(3).sendKeys("MenuTester2018");
        sp.getContinueButton().click();

        sp.getAllTextViews().get(3).click();

        sp.getCreditCardField().sendKeys("9010100052000004 0221");
        sp.getCreditCardCvvField().sendKeys("118");
        sp.getSignUpButton().click();

        //Assert if customer is created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu")));
        sp.getHamburgerMenu().click();
        Assert.assertTrue(sp.isMenageAccountOptionVisible(), "Customer account not created successfully!");
    }


    @AfterTest
    public void tearDown() {
        sp.getManageAccountLink().click();
        sp.getLogoutButton().click();
        super.tearDown();
    }
}
