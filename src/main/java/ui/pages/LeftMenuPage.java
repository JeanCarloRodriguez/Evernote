package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.common.CommonMethods;

/**
 * User: Jean Carlo Rodriguez
 * Date: 11/11/15
 * Time: 12:04 PM
 */
public class LeftMenuPage extends BasePageObject {
    @FindBy(id = "gwt-debug-Sidebar-newNoteButton-container")
    WebElement newNoteButton;

    @FindBy(xpath = "//div[@id='gwt-debug-AccountMenu-avatar']//img[contains(@src,'/shard/')]")
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

    /**
     * this method moves the page to notebooks page by clicking in notebooks button
     * @return an instance of NotebookPage
     */
    public NotebooksPage goToNotebooksPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(notebooksButton));
        notebooksButton.click();
        return new NotebooksPage();
    }

    /**
     * this method moves the page to notes page by clicking in notes button
     * @return an instance of NotesPage
     */
    public NotesPage goToNotesPage()
    {
        notesButton.click();
        return new NotesPage();
    }

    /**
     * this method call to AccountMenuPage to execute the logOut
     * @return an instance to LogOutPage
     */
    public LogOutPage logOut()
    {
        AccountMenuPage accountMenuPage = new AccountMenuPage();
        return accountMenuPage.logOut();
    }

    /**
     * this method moves the page to new note page
     * @return an instance of NewNotePage
     */
    public NewNotePage goToNewNotePage() {
        wait.until(ExpectedConditions.visibilityOf(newNoteButton));
        newNoteButton.click();
        return new NewNotePage();
    }

    /**
     * this method gets the email account from the account menu
     * @return a String that contains the email account
     */
    public String getEmailAccount() {
        //Open the accountMenuPage
        clickOnAccountMenuButton();
        AccountMenuPage accountMenuPage = new AccountMenuPage();
        String emailAccount = accountMenuPage.getEmailAccount();
        //Close the accountMenuPAge
        clickOnAccountMenuButton();
        return emailAccount;
    }
    public void clickOnAccountMenuButton()
    {
        accountMenuButton.click();
    }
}
