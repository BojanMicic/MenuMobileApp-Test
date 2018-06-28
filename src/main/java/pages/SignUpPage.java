package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SignUpPage extends BasePage {

    public SignUpPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getSignUpLink() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/buttonSignUp"));
    }

    public List<WebElement> getAllTextFields() {
        List<WebElement> textFields =  driver.findElements(By.id("com.usemenu.MenuAndroidApplication:id/edittext"));
        return textFields;
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/continueButton"));
    }

    public List<WebElement> getAllTextViews() {
        List<WebElement> textViews = driver.findElementsByClassName("android.widget.TextView");;
        return textViews;
    }

    public WebElement getCreditCardField() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/cc_card"));
    }

    public WebElement getCreditCardCvvField() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/cc_ccv"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/signUpButton"));
    }

    public WebElement getManageAccountLink() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/textviewAccountSettings"));
    }

    public boolean isMenageAccountOptionVisible() {
        try {
            driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/textviewAccountSettings"));
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/buttonManageAccountLogOut"));
    }

}
