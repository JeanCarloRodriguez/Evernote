package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: jeancarlorodriguez
 * Date: 11/25/15
 * Time: 11:10 AM
 */
public class ConfirmationPage extends BasePageObject {

    @FindBy(id = "gwt-debug-ConfirmationDialog-confirm")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@id='gwt-debug-GlassModalDialog-content']/div/div")
    WebElement confirmationMessage;

    public ConfirmationPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
    }

    public void confirm()
    {
        deleteButton.click();
    }
    public String getMessageOfDeleteConfirmation()
    {
        return confirmationMessage.getText();
    }
}
