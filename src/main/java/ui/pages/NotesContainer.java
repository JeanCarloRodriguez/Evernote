package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

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
}
