import static utils.StringUtils.generateRandomWord;

import org.junit.jupiter.api.Test;

import configuration.Configuration;
import steps.FileEditingScreenSteps;
import steps.MainScreenSteps;
import steps.SearchScreenSteps;
import steps.TextDocumentScreenSteps;

public class NextCloudTest extends BaseTest {

    private final MainScreenSteps mainScreenSteps;
    private final TextDocumentScreenSteps textDocumentScreenSteps;
    private final FileEditingScreenSteps fileEditingScreenSteps;
    private final SearchScreenSteps searchScreenSteps;

    public NextCloudTest() {
        this.mainScreenSteps = new MainScreenSteps();
        this.textDocumentScreenSteps = new TextDocumentScreenSteps();
        this.fileEditingScreenSteps = new FileEditingScreenSteps();
        this.searchScreenSteps = new SearchScreenSteps();
    }

    @Test
    public void firstTest() {
        String randomTitle = generateRandomWord(8);
        String randomText = generateRandomWord(12);

        mainScreenSteps.clickCancelInAlert();

        mainScreenSteps.clickAddButton();
        mainScreenSteps.clickCreateTextDocumentButton();

        mainScreenSteps.addTitleDocument(randomTitle);
        mainScreenSteps.clickCreateDocument();
        textDocumentScreenSteps.compareTitleDocument(randomTitle);
        fileEditingScreenSteps.checkFileEditingScreenDisplayed();

        fileEditingScreenSteps.writeText(randomText);
        fileEditingScreenSteps.clickCloseButton();
        mainScreenSteps.isDocumentPresent(randomTitle,true);

        mainScreenSteps.clickOverflowMenu(randomTitle);
        mainScreenSteps.deleteDocument();
    }

    @Test
    public void secondTest(){
        String randomTitle = generateRandomWord(8);
        String randomText = generateRandomWord(12);

        mainScreenSteps.clickCancelInAlert();

        mainScreenSteps.clickAddButton();
        mainScreenSteps.clickCreateTextDocumentButton();

        mainScreenSteps.addTitleDocument(randomTitle);
        mainScreenSteps.clickCreateDocument();
        textDocumentScreenSteps.compareTitleDocument(randomTitle);
        fileEditingScreenSteps.checkFileEditingScreenDisplayed();

        fileEditingScreenSteps.writeText(randomText);
        fileEditingScreenSteps.clickCloseButton();
        mainScreenSteps.isDocumentPresent(randomTitle,true);

        mainScreenSteps.clickOverflowMenu(randomTitle);
        mainScreenSteps.deleteDocument();
        mainScreenSteps.isDocumentPresent(randomTitle,false);

        mainScreenSteps.updateScreen();
        mainScreenSteps.isDocumentPresent(randomTitle,false);
    }

    @Test
    public void thirdTest(){
        String titleFile = Configuration.getProperties("titleFile");
        String description = Configuration.getProperties("description");

        mainScreenSteps.clickCancelInAlert();
        mainScreenSteps.isDocumentPresent(titleFile,true);

        mainScreenSteps.clickFile(titleFile);
        fileEditingScreenSteps.checkTextInEditText(description);
        fileEditingScreenSteps.clickCloseButton();
    }

    @Test
    public void fourthTest(){
        String titleFile = Configuration.getProperties("titleFile");

        mainScreenSteps.clickCancelInAlert();
        mainScreenSteps.isDocumentPresent(titleFile,true);

        mainScreenSteps.searchDocument(titleFile);
        searchScreenSteps.checkDocumentPresent(titleFile);
    }
}
