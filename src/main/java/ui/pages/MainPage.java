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
 * Date: 11/10/15
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPage extends BasePageObject {
    private LeftMenuPage leftMenuPage;

    @FindBy(id = "gwt-debug-NoteTitleView-textBox")
    WebElement noteTitleTextBox;

    @FindBy(id = "gwt-debug-sidebar")
    WebElement sideBar;

    private boolean isLoaded;
    public MainPage(){
        waitUntilPageObjectIsLoaded();
        leftMenuPage = new LeftMenuPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(sideBar));
        isLoaded = true;
        CommonMethods.elementHighlight(sideBar);
    }

    public boolean getIsLoaded()
    {
        return isLoaded;
    }

    public LeftMenuPage getLeftMenu() {
        return leftMenuPage;
    }
    //apparently this label is a generic one for all situations
    public String getErrorMessage()
    {
        WebElement errorMessageText = driver.findElement(By.xpath("//span[@class='gwt-InlineLabel']"));
        return errorMessageText.getText();
    }
}
