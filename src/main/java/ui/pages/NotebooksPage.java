package ui.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[contains(@class,'GLATSGFCCSB GLATSGFCGTB qa-notebookWidget qa-trash')]")
    WebElement trashButton;


    public NotebooksPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(slidingPanel));
        CommonMethods.elementHighlight(slidingPanel);
    }

    public NewNotebookPage goToNewNoteBookPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(newNotebookButton));
        newNotebookButton.click();
        return new NewNotebookPage();
    }


    public DeleteNotebookConfirmationPage deleteANotebookCalled(String notebookName) {

        WebElement deleteNotebookButton = driver.findElement(By.xpath("//div[@id = 'gwt-debug-notebooksDrawerSlidingPanel']//div[(text()='"+notebookName+"')]//following-sibling::div//div[contains(@class,'qa-deleteButton')]"));
        deleteNotebookButton.click();
        return new DeleteNotebookConfirmationPage();

    }

    public boolean isNotebookExist(String notebookName)
    {
        WebElement notebook = findElement(By.xpath("//div[@id = 'gwt-debug-notebooksDrawerSlidingPanel']//div[(text()='"+notebookName+"')]"));
        return isPresent(notebook);

    }
}
