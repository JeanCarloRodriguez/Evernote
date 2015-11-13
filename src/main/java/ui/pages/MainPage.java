package ui.pages;

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

    private boolean isLoaded;
    public MainPage(){
        leftMenuPage = new LeftMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(noteTitleTextBox));
        setIsLoaded(true);
        //CommonMethods.elementHighlight(noteTitleTextBox);
    }

    public boolean getIsLoaded()
    {
        return isLoaded;
    }

    public void setIsLoaded(boolean loaded)
    {
        isLoaded = loaded;
    }

    public LeftMenuPage getLeftMenu() {
        return leftMenuPage;
    }
}
