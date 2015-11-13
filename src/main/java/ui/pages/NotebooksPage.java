package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.common.CommonMethods;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/12/15
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotebooksPage extends BasePageObject {

    @FindBy(xpath = "//div[@id='gwt-debug-notebooksDrawerSlidingPanel']")
    WebElement slidingPanel;

    @FindBy(xpath = "//div[@id='gwt-debug-NotebooksDrawer-createNotebookButton']")
    WebElement newNotebookButton;

    @FindBy(xpath = "//div[contains(@id,'gwt-debug-NotebooksDrawer-title')]")
    WebElement notebookTitle;

    @FindBy(xpath = "//div[contains(@class,'GLATSGFCCSB GLATSGFCGTB qa-notebookWidget qa-trash')]")
    WebElement trashButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(slidingPanel));
        CommonMethods.sleep(10000);
        CommonMethods.elementHighlight(slidingPanel);
    }

    public newNotebookPage goToNewNoteBookPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(newNotebookButton));
        /*if (newNotebookButton.isEnabled())
        {
            newNotebookButton.click();
        }else
        {
            wait.until(ExpectedConditions.elementToBeClickable(newNotebookButton));
            newNotebookButton.click();
        }*/
        newNotebookButton.click();
        newNotebookButton.click();

        return new newNotebookPage();
    }


}
