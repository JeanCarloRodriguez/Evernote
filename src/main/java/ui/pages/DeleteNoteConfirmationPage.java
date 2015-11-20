package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: Jean Carlo Rodriguez
 * Date: 11/16/15
 * Time: 2:53 PM
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

    /**
     * This method clicks in delete button to remove the note
     * @return a instance of NotePage
     */
    public NotesPage delete()
    {
        deleteButton.click();
        return new NotesPage();
    }

    /**
     * this method return the confirmation message at delete a note
     * @return a String with the message of confirmation
     */
    public String getMessageOfDeleteConfirmation()
    {
        return confirmationMessage.getText();
    }

}
