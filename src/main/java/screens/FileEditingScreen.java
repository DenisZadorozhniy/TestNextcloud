package screens;

import org.openqa.selenium.By;

import java.time.Duration;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;

public class FileEditingScreen extends Screen {

    private final ILabel directEditor;
    private final IButton closeButton;

    public FileEditingScreen() {
        super(By.id("com.nextcloud.client:id/webView"), "File editing screen");
        this.directEditor = getElementFactory().getLabel(By.xpath("//android.widget.EditText"),"Edit text");
        this.closeButton = getElementFactory().getButton(By.xpath("//android.widget.Button[contains(" +
                "@index,'4')]"),"Close button");
    }

    public boolean isFileEditingScreenDisplayed() {
        state().waitForDisplayed(Duration.ofSeconds(30));
        return state().isDisplayed();
    }

    public void addText(String text){
        directEditor.sendKeys(text);
    }

    public void clickCloseBtn(){
        closeButton.click();
    }

    public String getTextFromDirectEditor(){
        return directEditor.getText();
    }
}
