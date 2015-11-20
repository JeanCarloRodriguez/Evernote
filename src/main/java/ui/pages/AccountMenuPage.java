package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: Jean Carlo Rodriguez
 * Date: 11/18/15
 * Time: 10:26 AM
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

    /**
     * this method returns the email with that the user is logged in
     */
    public String getEmailAccount()
    {
        return emailAccountLabel.getText();
    }

    /**
     * this method log out the user account
     * @return a instance of the class LogOutPage
     */
    public LogOutPage logOut() {
        logOutButton.click();
        return new LogOutPage();
    }
}
