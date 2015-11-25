package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

import java.util.List;

/**
 * User: jeancarlorodriguez
 * Date: 11/23/15
 * Time: 8:38 PM
 */
public abstract class NotesContainer extends BasePageObject {
    @FindBy(xpath = "//div[@class='focus-NotesView-Subheader']//div[contains(@class,'qa-notesCount')]")
    WebElement notesCountLabel;

    @FindBy(xpath = "//div[@class='focus-NotesView-Subheader']//div[@class='Dropdown-button']")
    WebElement notesOptionDropDownButton;

    List<WebElement> listOfNotes;
    public void chooseSortOption(String sortOption)
    {
        notesOptionDropDownButton.click();
        WebElement sortOptionSelector = driver
                .findElement(By.xpath("//div[@class='Dropdown-menu Dropdown-fixed']//div[contains(@class,'SelectorOption')][text()='" + sortOption + "']"));
        if(sortOptionSelector.getAttribute("class").contains("selected"))
        {
            notesOptionDropDownButton.click();
        }
        else{
            sortOptionSelector.click();
        }
    }
    public String getNotesCount()
    {
        return notesCountLabel.getText();
    }

    public void getListOfNotes()
    {
        listOfNotes = driver.findElements(By.xpath("//div[@class='NotesView-ScrollWindow']//div[contains(@class,'qa-title')]"));
        if(!listOfNotes.isEmpty())
        {
            for (WebElement item : listOfNotes)
            {
                System.out.println("elements of the note list: "+item.getText());
            }
        }
    }

    public String getFirstNote()
    {
        getListOfNotes();
        if(!listOfNotes.isEmpty())
        {
            return listOfNotes.get(0).getText();
        }
        return "";
    }
    public boolean isNoteExist(String notebookName)
    {
        return isPresent(By.xpath("//div[@class = 'NotesView-ScrollWindow']//div[text() = '"+notebookName+"']"));
    }
}
