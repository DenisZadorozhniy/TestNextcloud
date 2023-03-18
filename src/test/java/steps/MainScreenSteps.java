package steps;

import static utils.AlertManager.dismissAlert;
import static utils.StringUtils.getLastNumber;
import static utils.SwipeUtils.swipeWithDirection;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import aquality.appium.mobile.actions.SwipeDirection;
import screens.MainScreen;
import utils.StringUtils;

public class MainScreenSteps {

    private final MainScreen mainScreen;

    public MainScreenSteps() {
        this.mainScreen = new MainScreen();
    }

    public void clickAddButton() {
        mainScreen.clickAddFileButton();
    }

    public void clickCreateTextDocumentButton() {
        mainScreen.getAddFileForm().clickCreateNewTextDocumentButton();
    }

    public void clickCancelInAlert() {
        dismissAlert();
    }

    public void addTitleDocument(String titleDocument) {
        mainScreen.getAddFileForm().addTitleInTextDocument(titleDocument);
    }

    public void clickCreateDocument() {
        mainScreen.getAddFileForm().clickCreateDocumentButton();
    }

    public void isDocumentPresent(String titleDocument, boolean expectedPresence) {
        mainScreen.state().waitForClickable(Duration.ofSeconds(7));
        List<String> titles = mainScreen.getTitleFromDocuments().stream()
                .map(StringUtils::extractTextBeforeDotOrColon)
                .collect(Collectors.toList());
        if (expectedPresence) {
            Assertions.assertTrue(titles.contains(titleDocument),
                    String.format("The '%s' file must be present in the list of files.", titleDocument));
        } else {
            Assertions.assertFalse(titles.contains(titleDocument),
                    String.format("The '%s' file must be not present in the list of files.", titleDocument));
        }
    }

    public void clickOverflowMenu(String titleDocument) {
        Integer lastNumber = getLastNumber(mainScreen.getFilenameLocator(titleDocument).toString());
        mainScreen.clickMoreMenu(lastNumber);
    }

    public void deleteDocument() {
        mainScreen.getMoreMenuForm().clickDeleteButton();
        mainScreen.getDeletionWarningForm().clickDelete();
    }

    public void updateScreen() {
        swipeWithDirection(SwipeDirection.UP);
    }

    public void clickFile(String titleDocument) {
        Integer lastNumber = getLastNumber(mainScreen.getFilenameLocator(titleDocument).toString());
        mainScreen.clickOnParticularDocument(lastNumber);
    }

    public void searchDocument(String title) {
        mainScreen.writeTextToSearch(title);
        mainScreen.startSearch();
    }
}
