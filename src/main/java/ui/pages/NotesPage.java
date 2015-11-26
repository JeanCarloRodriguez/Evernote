package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.common.CommonMethods;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/14/15
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotesPage extends NotesContainer {

    @FindBy(xpath = "//div[@class=\'NotesView-ScrollWindow\']")
    WebElement notesView;

    public NotesPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(notesView));
    }

    public boolean isNoteExist(String noteName)
    {
        return isPresent(By.xpath("//div[@class = 'NotesView-ScrollWindow']//div[text() = '"+noteName+"']"));
    }
    public boolean theNoteWasDeleted(String noteName)
    {
        return isDeleted(Integer.parseInt(CommonMethods.readJsonFile("NumberOfTriesForElementDeleted")), By.xpath("//div[@class = 'NotesView-ScrollWindow']//div[text() = '" + noteName + "']"));
    }

    public ConfirmationPage goToDeleteNoteConfirmationPage(String noteName)
    {
        WebElement deleteNoteButton = driver.findElement(By.xpath("//div[@class = 'NotesView-ScrollWindow']//div[text() = '"+noteName+"']//parent::div//following-sibling::div//div[contains(@class,'qa-deleteButton')]"));
        deleteNoteButton.click();
        return new ConfirmationPage();
    }

    public String getDeleteMessage()
    {
        WebElement deleteMessage = driver.findElement(By.xpath("//div[@class='gwt-HTML'][contains(text(),'moved to')]"));
        return deleteMessage.getText();
    }

}
