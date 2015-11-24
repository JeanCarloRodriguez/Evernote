package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * User: jeancarlorodriguez
 * Date: 11/21/15
 * Time: 2:30 PM
 */
public class TrashPage extends NotesContainer {

    @FindBy(id = "gwt-debug-trashHeaderContainer")
    WebElement trashHeader;

    @FindBy(xpath = "//div[@id='gwt-debug-trashHeaderContainer']//button[text()='Empty trash']")
    WebElement emptyButton;

    //@FindBy(xpath = "//div[@class='focus-NotesView-Subheader']//div[contains(@class,'qa-notesCount')]")
    //WebElement notesCountLabel;

    public TrashPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(trashHeader));
    }

    public EmptyTrashConfirmationPage clickOnEmptyButton()
    {
        emptyButton.click();
        return new EmptyTrashConfirmationPage();
    }


    public TrashPage emptyAllNotes()
    {
        clickOnEmptyButton().confirm();
        return this;
    }



    public boolean isEmpty()
    {
        return isDeleted(10,By.xpath("//div[@class='NotesView-ScrollWindow']//div[contains(@class,'Notes')]"));
    }

}
