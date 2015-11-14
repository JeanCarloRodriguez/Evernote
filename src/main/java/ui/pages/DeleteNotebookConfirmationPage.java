package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/14/15
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
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

    public NotebooksPage delete()
    {
        deleteButton.click();
        return new NotebooksPage();
    }

    public String getMessageOfDeleteConfirmation()
    {
        return confirmationMessage.getText();
    }
}
