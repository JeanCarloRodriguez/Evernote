package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: Jean Carlo Rodriguez
 * Date: 11/10/15
 * Time: 5:36 PM
 */
public class HomePage extends BasePageObject {

    @FindBy(xpath = "//form[contains(@id,'create-account') ]//a[@class='login-link click_tracking']")
    @CacheLookup
    WebElement signInButton;

    public HomePage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    /**
     * this method moves the page to the Login Page by clicking the sign in button
     * @return an instance of LoginPage
     */
    public LoginPage goToLoginPage()
    {
        signInButton.click();
        return new LoginPage();
    }
}
