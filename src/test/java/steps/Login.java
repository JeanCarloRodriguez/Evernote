package steps;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.common.CommonMethods;
import ui.pages.LogOutPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import org.testng.Assert;

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
    String userEmail;
    boolean loggedIn;
    public Login(){
        loggedIn = false;
    }
    private PageTransporter pageTransporter = PageTransporter.getInstance();

    @Given("^I Login into the web page with a correct email \"([^\\\"]*)\" and the password \"([^\\\"]*)\"$")
    public void loginIntoWebPageSuccess(String user, String password)
    {
        loginPage = new LoginPage();
        mainPage = loginPage.loginSuccessful(user,password);
        userEmail = user;
        loggedIn = true;
    }

    @Then("^I am in the main page$")
    public void IAmInTheMainPage()
    {
        boolean actualPageLoaded = mainPage.getIsLoaded();
        boolean expectedPageLoaded = true;
        Assert.assertEquals(actualPageLoaded,expectedPageLoaded);
    }

    @And("^Im login with the correct user$")
    public void imLoginWithTheCorrectUser(){
        String emailAccount = mainPage.getLeftMenu().getEmailAccount();
        String actualResult = emailAccount;
        String expectedResult = userEmail.toUpperCase();
        Assert.assertEquals(actualResult,expectedResult);
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
        logOutPage =mainPage.logOut();
        loggedIn = false;
    }
    @Then("^a message is displayed confirming the log out$")
    public void aMessageIsDisplayedConfirmingTheLogOut()
    {
        String actualResult = logOutPage.getLogOutMessage();
        String expectedResult = "You have successfully been logged out of Evernote.";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Given("I log in with the user \"([^\\\"]*)\" and the password \"([^\\\"]*)\"")
    public void iLogInWithTheUserAndPassword(String user, String password)
    {


        if(!CommonMethods.theAccountIsLogin())
        {
            pageTransporter.goToLogin();
            loginIntoWebPageSuccess(user, password);
        }
        else{
            loggedIn = true;
            System.out.println("The account :"+user+" is already log in");
        }
    }

    @Given("^I go to the main Page$")
    public void iGoToTheMainPage()
    {
        pageTransporter.goToMain();
    }

    @Before("@Login")
    public void verifyLogoutUser()
    {
        if(loggedIn)
        {
            PageTransporter.getInstance().goToMain();
            iLogOut();
        }
    }
}
