package utils;

import static aquality.appium.mobile.application.AqualityServices.getApplication;
import org.openqa.selenium.Alert;

public class AlertManager {
    private static Alert alert = getApplication().getDriver().switchTo().alert();

    public static void dismissAlert() {
        alert.dismiss();
    }

    public static void acceptAlert(){
        alert.accept();
    }
}
