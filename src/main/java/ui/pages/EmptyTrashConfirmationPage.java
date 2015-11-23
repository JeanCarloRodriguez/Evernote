package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.common.CommonMethods;

/**
 * User: jeancarlorodriguez
 * Date: 11/21/15
 * Time: 3:03 PM
 */
public class EmptyTrashConfirmationPage extends BasePageObject {

    @FindBy(id = "gwt-debug-ConfirmationDialog-confirm")
    WebElement emptyConfirmationButton;

    public EmptyTrashConfirmationPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(emptyConfirmationButton));
        CommonMethods.elementHighlight(emptyConfirmationButton);
    }

    public void confirm()
    {
        emptyConfirmationButton.click();
    }
}
