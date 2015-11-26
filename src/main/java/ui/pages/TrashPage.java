package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.common.CommonMethods;

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

    public TrashPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(trashHeader));
    }

    public ConfirmationPage clickOnEmptyButton()
    {
        emptyButton.click();
        return new ConfirmationPage();
    }


    public TrashPage emptyAllNotes()
    {
        //Todo the button empty is not present when the number of notes is 0
        if(!getNotesCount().equalsIgnoreCase("0 notes"))
        {
            clickOnEmptyButton().confirm();
            isEmpty();
        }else{
            System.out.println("the trash is already empty");
        }

        return this;
    }



    public boolean isEmpty()
    {
        return isDeleted(Integer.parseInt(CommonMethods.readJsonFile("NumberOfTriesForElementDeleted")),By.xpath("//div[@class='NotesView-ScrollWindow']//div[contains(@class,'Notes')]"));
    }

}
