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
    WebElement newNoteButton;

    @FindBy(xpath = "//div//img[@class='GLATSGFCDQ']")
    WebElement accountButton;

    @FindBy(id = "gwt-debug-AccountMenuPopup-root")
    WebElement accountMenu;

    @FindBy(xpath = "//div[@class='GLATSGFCF-B']/div[3]/div[3]")
    WebElement notebookButton;

    @FindBy(xpath = "//div[@class='GLATSGFCF-B']/div[3]/div[2]")
    WebElement noteButton;

    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    WebElement logOutButton;
    public LeftMenuPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("from Left Menu: "+accountButton.getAttribute("src"));
        wait.until(ExpectedConditions.visibilityOf(accountButton));

        while(!accountButton.getAttribute("src").contains("www.evernote.com"))
        {
            CommonMethods.sleep(500);
            System.out.println("from while: "+accountButton.getAttribute("src").contains("www.evernote.com")+"    "+accountButton.getAttribute("src"));
        }

        CommonMethods.elementHighlight(accountButton);
    }

    public NotebooksPage goToNotebooksPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(notebookButton));
        notebookButton.click();
        return new NotebooksPage();
    }
    public NotePage goToNoteButton()
    {
        noteButton.click();
        return new NotePage();
    }

    public LogOutPage logOut()
    {
        accountButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountMenu));
        logOutButton.click();
        return new LogOutPage();
    }

    public NewNotePage goToNewNotePage() {
        newNoteButton.click();
        return new NewNotePage();
    }
}
