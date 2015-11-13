package steps;
import Framework.DriverManager;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jdk.nashorn.internal.runtime.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.LogOutPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/9/15
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {
    MainPage mainPage;
    LoginPage loginPage;
    LogOutPage logOutPage;


    @Given("^I Login into the web page with a correct email \"([^\\\"]*)\" and the password \"([^\\\"]*)\"$")
    public void loginIntoWebPageSuccess(String user, String password)
    {
        LoginPage login = new LoginPage();
        mainPage = login.loginSuccessful(user,password);
    }

    @Then("^I am in the main page$")
    public void IAmInTheMainPage()
    {
        boolean actualPageLoaded = mainPage.getIsLoaded();
        boolean expectedPageLoaded = true;
        Assert.assertEquals(actualPageLoaded,expectedPageLoaded);
    }

    @Given("^I Login into the web page with a wrong email \"([^\\\"]*)\" and the password \"([^\\\"]*)\"$")
    public void loginIntoWebPageFail(String user, String password)
    {
        loginPage = new LoginPage();
        String errorMessage = loginPage.loginFailed(user,password)
                .getErrorMessage();
        System.out.println(errorMessage);


    }



    @Then("^a message error \"([^\\\"]*)\" is displayed for the login failed$")
    public void errorMessageFromLogin(String errorMessage)
    {
        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult,errorMessage);
    }

    @When("^I log out$")
    public void iLogOut()
    {
        logOutPage =mainPage.getLeftMenu()
                .logOut();
    }
    @Then("^a message is displayed confirming the log out$")
    public void aMessageIsDisplayedConfirmingTheLogOut()
    {
        String actualResult = logOutPage.getLogOutMessage();
        String expectedResult = "You have successfully been logged out of Evernote.";
        Assert.assertEquals(actualResult,expectedResult);

    }

    /*
    @After("@loginFailed")
    public void afterLoginFailed()
    {
        DriverManager.getInstance().goToRoot();
        //DriverManager.getInstance().close();
    }

    @After("@login")
    public void exitLogin()
    {
        DriverManager.getInstance().close();
    }*/
}
