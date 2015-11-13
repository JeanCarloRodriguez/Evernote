package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/10/15
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends BasePageObject {
    //private WebDriver driver;
    //private WebDriverWait wait;

    @FindBy(xpath = "//form[contains(@id,'create-account') ]//a[@class='login-link click_tracking']")
    @CacheLookup
    WebElement signInButton;

    public HomePage(){
        //waitUntilPageObjectIsLoaded();
    }

    public LoginPage goToLoginPage()
    {
        signInButton.click();
        return new LoginPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }
}
