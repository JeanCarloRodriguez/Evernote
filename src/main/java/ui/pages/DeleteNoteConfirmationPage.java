package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/16/15
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteNoteConfirmationPage extends BasePageObject {

    @FindBy(id = "gwt-debug-ConfirmationDialog-confirm")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@class='GLATSGFCO4B GLATSGFCLD']")
    WebElement confirmationMessage;

    public DeleteNoteConfirmationPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
    }

    public NotesPage delete()
    {
        deleteButton.click();
        return new NotesPage();
    }

    public String getMessageOfDeleteConfirmation()
    {
        return confirmationMessage.getText();
    }

}
