package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/13/15
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class newNotebookPage extends BasePageObject {

    @FindBy(id = "gwt-debug-CreateNotebookDialog-centeredTextBox-textBox")
    WebElement newNotebookTitle;

    @FindBy(xpath = "//span[@id='gwt-debug-CreateNotebookDialog-confirm'][@class='GLATSGFCGF GLATSGFCHF GLATSGFCDD']")
    WebElement createNotebookButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newNotebookTitle));
    }

    public NotebookPage createANotebook(String name) {
        newNotebookTitle.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(createNotebookButton));
        createNotebookButton.click();
        return new NotebookPage();
    }
}
