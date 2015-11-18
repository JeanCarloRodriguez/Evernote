package ui.pages;

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
    @FindBy(xpath = "//div[@class='GLATSGFCF-B']/div[2]/div[1]")
    //@FindBy(xpath = "//div[@id='gwt-debug-sidebar']//span[text()='New note']")
    WebElement newNoteButton;

    @FindBy(xpath = "//div//img[@class='GLATSGFCDQ'][contains(@src,'/shard/')]")
    WebElement accountButton;

    @FindBy(id = "gwt-debug-AccountMenuPopup-root")
    WebElement accountMenu;

    @FindBy(xpath = "//div[@class='GLATSGFCF-B']/div[3]/div[3]")
    //@FindBy(xpath = "//div[@id='gwt-debug-sidebar']//span[text()='Notebooks']")
    WebElement notebooksButton;

    @FindBy(xpath = "//div[@class='GLATSGFCF-B']/div[3]/div[2]")
    WebElement notesButton;

    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    WebElement logOutButton;
    public LeftMenuPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountButton));
        CommonMethods.elementHighlight(accountButton);
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
        accountButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountMenu));
        logOutButton.click();
        return new LogOutPage();
    }

    public NewNotePage goToNewNotePage() {
        wait.until(ExpectedConditions.visibilityOf(newNoteButton));
        newNoteButton.click();
        return new NewNotePage();
    }
}
