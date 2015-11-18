package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/13/15
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotebookPage extends BasePageObject {

    @FindBy(id = "gwt-debug-NotebookHeader-name")
    WebElement notebookTitle;

    @FindBy(xpath = "//span[@class='gwt-InlineLabel']")
    WebElement errorMessageText;

    public NotebookPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(notebookTitle));
    }

    public String getNotebookTitle()
    {
        System.out.println("the name of the new notebook is: "+notebookTitle.getText());
        return notebookTitle.getText();
    }
    public boolean isNoteExist(String notebookName)
    {
        return isPresent(By.xpath("//div[@class = 'NotesView-ScrollWindow']//div[text() = '"+notebookName+"']"));
    }


}
