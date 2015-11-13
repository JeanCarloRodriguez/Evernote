package ui.pages;

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

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(notebookTitle));
        System.out.println("title for the notebook found!!!!!!!!!");
    }

    public String getNotebookTitle()
    {
        System.out.println("the name of the new notebook is: "+notebookTitle.getText());
        return notebookTitle.getText();
    }
}
