package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/14/15
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewNotePage extends BasePageObject{

    @FindBy(id = "gwt-debug-NoteView-root")
    WebElement noteView;

    @FindBy(id = "gwt-debug-NotebookSelectMenu-notebookName")
    WebElement notebookSelectMenu;

    @FindBy(id = "gwt-debug-NoteTitleView-textBox")
    WebElement noteTitleField;

    @FindBy(id = "gwt-debug-NoteAttributes-doneButton")
    WebElement doneButton;

    public NewNotePage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(noteView));
    }

    public NotesPage createNote(String noteName, String notebookName)
    {
        noteTitleField.sendKeys(noteName);
        selectNoteBook(notebookName);
        doneButton.click();
        return new NotesPage();
    }

    public void selectNoteBook(String noteBookName)
    {
        if(notebookSelectMenu.getText()!=noteBookName)
        {
            wait.until(ExpectedConditions.elementToBeClickable(notebookSelectMenu));
            notebookSelectMenu.click();
            WebElement selectedNotebook = findElement(By.xpath("//div[@id='gwt-debug-notebookSelectMenu-slidingPanel']//div[text()='"+noteBookName+"']"));
            selectedNotebook.click();
        }
    }
}
