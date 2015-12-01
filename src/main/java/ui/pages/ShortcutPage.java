package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: jeancarlorodriguez
 * Date: 11/30/15
 * Time: 7:29 PM
 */
public class ShortcutPage extends BasePageObject {

    @FindBy(id = "gwt-debug-ShortcutsDrawerView-root")
    WebElement shortcutDrawerView;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(shortcutDrawerView));
    }
    public boolean isShortcutPresent(String name)
    {
        return isPresent(By.xpath("//div[contains(@class,'qa-name')][text()='"+name+"']"));
    }

    public boolean isShortcutDeleted(String name)
    {
        return isDeleted(10,By.xpath("//div[contains(@class,'qa-name')][text()='"+name+"']"));
    }

    public ShortcutPage removeShortcut(String shortcutName) {
        WebElement removeShortcutButton = driver.findElement(By.xpath("//div[@id='gwt-debug-ShortcutsDrawerView-root']//div[contains(@class,'qa-name')][text()='"+ shortcutName+"']//parent::div//following-sibling::div//input"));
        removeShortcutButton.click();
        return this;
    }
}
