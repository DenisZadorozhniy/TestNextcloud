package screens.forms;

import static utils.SwipeUtils.makeSwipe;

import org.openqa.selenium.By;

import java.time.Duration;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;

public class AddFileForm extends Screen {

    private final IButton createNewTextDocumentButton;
    private final ILabel textField;
    private final IButton createDocumentButton;

    public AddFileForm() {
        super(By.id("com.nextcloud.client:id/design_bottom_sheet"), "Add file form");
        this.createNewTextDocumentButton = getElementFactory().getButton((By.xpath("/hierarchy/android.widget." +
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android." +
                        "widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android." +
                        "widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout[4]")),
                "Create new text document button");
        this.textField = getElementFactory().getLabel(By.id("com.nextcloud.client:id/filename"),"Text field");
        this.createDocumentButton = getElementFactory().getButton(By.id("android:id/button1"),"Create document button");
    }

    public void clickCreateNewTextDocumentButton(){
        makeSwipe(createNewTextDocumentButton, SwipeDirection.DOWN);
        createNewTextDocumentButton.click();
    }

    public void addTitleInTextDocument(String title){
        textField.sendKeys(title);
    }


    public void clickCreateDocumentButton() {
        createDocumentButton.state().waitForClickable(Duration.ofSeconds(5));
        createDocumentButton.click();
    }
}
