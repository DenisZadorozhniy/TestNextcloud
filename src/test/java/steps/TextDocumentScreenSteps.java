package steps;

import static utils.StringUtils.extractTextBeforeDotOrColon;

import org.junit.jupiter.api.Assertions;

import screens.TextDocumentScreen;

public class TextDocumentScreenSteps {
    private final TextDocumentScreen textDocumentScreen;

    public TextDocumentScreenSteps() {
        this.textDocumentScreen = new TextDocumentScreen();
    }

    public void compareTitleDocument(String titleDocument) {
        if (textDocumentScreen.isTextDocumentScreenDisplayed()) {
            Assertions.assertEquals(extractTextBeforeDotOrColon(textDocumentScreen.getTitleDocumentText()), titleDocument, "Titles must be the equal");
        }
    }
}
