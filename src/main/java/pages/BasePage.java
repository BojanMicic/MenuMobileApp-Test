package pages;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage {
    AppiumDriver driver;

    public BasePage(AppiumDriver driverPage){
        this.driver = driverPage;
    }

}
