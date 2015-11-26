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

    @FindBy(xpath = "//div[contains(@class,'qa-trash')]")
    WebElement trashButton;


    public NotebooksPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(slidingPanel));
    }

    public NewNotebookPage goToNewNoteBookPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(newNotebookButton));
        newNotebookButton.click();
        return new NewNotebookPage();
    }


    public ConfirmationPage deleteANotebookCalled(String notebookName) {

        WebElement deleteNotebookButton = driver.findElement(By.xpath("//div[@id = 'gwt-debug-notebooksDrawerSlidingPanel']//div[(text()='"+notebookName+"')]//following-sibling::div//div[contains(@class,'qa-deleteButton')]"));
        deleteNotebookButton.click();
        return new ConfirmationPage();

    }

    public boolean isNotebookExist(String notebookName)
    {
        return isPresent(By.xpath("//div[@id = 'gwt-debug-notebooksDrawerSlidingPanel']//div[(text()='"+notebookName+"')]"));
    }
    public TrashPage goToTrash()
    {
        trashButton.click();
        return new TrashPage();
    }
}
