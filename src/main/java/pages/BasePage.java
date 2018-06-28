package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    AppiumDriver driver;

    public BasePage(AppiumDriver driverPage){
        this.driver = driverPage;
    }

    public WebElement getHamburgerMenu() {
        return driver.findElement(By.id("com.usemenu.MenuAndroidApplication:id/imageButtonActionBarMenu"));
    }

}
