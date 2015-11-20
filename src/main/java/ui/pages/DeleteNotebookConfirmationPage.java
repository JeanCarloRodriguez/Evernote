package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: Jean Carlo Rodriguez
 * Date: 11/14/15
 * Time: 2:19 PM
 */
public class DeleteNotebookConfirmationPage extends BasePageObject {
    @FindBy(id = "gwt-debug-ConfirmationDialog-confirm")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@class='GLATSGFCO4B GLATSGFCLD']")
    WebElement confirmationMessage;

    public DeleteNotebookConfirmationPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
    }

    /**
     * This method clicks in delete button to remove the notebook
     * @return a instance of NotebooksPage
     */
    public NotebooksPage delete()
    {
        deleteButton.click();
        return new NotebooksPage();
    }

    /**
     * this method return the confirmation message at delete a notebook
     * @return a String with the message of confirmation
     */
    public String getMessageOfDeleteConfirmation()
    {
        return confirmationMessage.getText();
    }
}
