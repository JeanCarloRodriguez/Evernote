package ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

/**
 * Created by silvia valencia on 3/24/2015.
 */
public class LoginPage extends BasePageObject {

    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement signInButton;

    @FindBy(xpath = "//div[contains(@id,'assword-wrapper')]//div[contains(@class,'error-status FieldState-message FieldState_error-message')]")
    WebElement errorStatusField;
    public LoginPage() {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
    }

    private void setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    private void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void clickSignInButton() {
        signInButton.click();
    }

    public MainPage loginSuccessful(String userName, String password) {
        setFields(userName,password);
        clickSignInButton();
        return new MainPage();
    }
    public void setFields(String userName,String password)
    {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    public LoginPage loginFailed(String userName,String password)
    {
        setFields(userName,password);
        clickSignInButton();

        return this;
    }
    public String getErrorMessage()
    {
        return errorStatusField.getText();
    }
}
