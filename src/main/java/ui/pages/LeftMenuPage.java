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
 * Date: 11/11/15
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LeftMenuPage extends BasePageObject {
    @FindBy(id = "gwt-debug-Sidebar-newNoteButton-container")
    WebElement newNoteButton;

    @FindBy(xpath = "//div//img[@class='GLATSGFCDQ'][contains(@src,'/shard/')]")
    WebElement accountMenuButton;

    @FindBy(id = "gwt-debug-Sidebar-notebooksButton-container")
    WebElement notebooksButton;

    @FindBy(id = "gwt-debug-Sidebar-notesButton-container")
    WebElement notesButton;


    public LeftMenuPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountMenuButton));
        CommonMethods.elementHighlight(accountMenuButton);
    }

    public NotebooksPage goToNotebooksPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(notebooksButton));
        notebooksButton.click();
        return new NotebooksPage();
    }
    public NotesPage goToNotesPage()
    {
        notesButton.click();
        return new NotesPage();
    }

    public LogOutPage logOut()
    {
        AccountMenuPage accountMenuPage = new AccountMenuPage();
        return accountMenuPage.logOut();
    }

    public NewNotePage goToNewNotePage() {
        wait.until(ExpectedConditions.visibilityOf(newNoteButton));
        newNoteButton.click();
        return new NewNotePage();
    }

    public String getEmailAccount() {
        //Open the accountMenuPage
        accountMenuButton.click();
        AccountMenuPage accountMenuPage = new AccountMenuPage();
        //Close the accountMenuPAge
        accountMenuButton.click();
        return accountMenuPage.getEmailAccount();
    }
    public void clickOnAccountMenuButton()
    {
        accountMenuButton.click();
    }
}
