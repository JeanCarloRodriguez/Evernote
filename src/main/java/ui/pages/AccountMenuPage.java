package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/18/15
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountMenuPage extends BasePageObject {

    @FindBy(id = "gwt-debug-AccountMenuPopup-root")
    WebElement accountMenuPopup;

    @FindBy(id = "gwt-debug-AccountMenu-name")
    WebElement emailAccountLabel;

    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    WebElement logOutButton;

    public AccountMenuPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountMenuPopup));
    }
    public String getEmailAccount()
    {
        return emailAccountLabel.getText();
    }

    public LogOutPage logOut() {
        logOutButton.click();
        return new LogOutPage();
    }
}
