package screens;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;

public class SearchScreen extends Screen {

    private final List<ITextBox> elementsInRecycler;

    public SearchScreen() {
        super(By.id("com.nextcloud.client:id/unified_search_item_layout"), "Search screen");
        this.elementsInRecycler = getElementFactory().findElements(By.xpath("//*" +
                "[contains(@resource-id,'com.nextcloud.client:id/title')]"),ITextBox.class);
    }

    public List<String> getTitleFromDocuments() {
        state().waitForClickable(Duration.ofSeconds(5));
        List<String> titlesList = new ArrayList<>();
        if (!elementsInRecycler.isEmpty()) {
            elementsInRecycler.forEach(element -> {
                String text = element.getText();
                titlesList.add(text);
            });
        }
        return titlesList;
    }
}
