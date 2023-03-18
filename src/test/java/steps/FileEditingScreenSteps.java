package steps;

import static utils.StringUtils.removeTrailingSpaces;

import org.junit.jupiter.api.Assertions;

import screens.FileEditingScreen;

public class FileEditingScreenSteps {
    private final FileEditingScreen fileEditingScreen;

    public FileEditingScreenSteps() {
        this.fileEditingScreen = new FileEditingScreen();
    }

    public void checkFileEditingScreenDisplayed() {
        Assertions.assertTrue(fileEditingScreen.isFileEditingScreenDisplayed(),
                "File editing screen should be displayed");
    }

    public void writeText(String text) {
        fileEditingScreen.addText(text);
    }

    public void clickCloseButton() {
        fileEditingScreen.clickCloseBtn();
    }

    public void checkTextInEditText(String text) {
        Assertions.assertEquals(removeTrailingSpaces(fileEditingScreen.getTextFromDirectEditor()), text,
                "Values must be equal");
    }
}
