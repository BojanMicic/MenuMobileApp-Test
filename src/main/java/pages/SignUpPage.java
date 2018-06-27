package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class SignUpPage extends BasePage {

    public SignUpPage(AppiumDriver driver) {
        super(driver);
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

}
