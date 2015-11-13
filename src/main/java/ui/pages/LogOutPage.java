package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/13/15
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class LogOutPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'container')]/h1")
    WebElement logOutMessage;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logOutMessage));
    }
    public String getLogOutMessage()
    {
        return logOutMessage.getText();
    }

}
