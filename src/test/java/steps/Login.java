package steps;
import Framework.DriverManager;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/9/15
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {


    @Given("^I Login into the web page with the email \"([^\\\"]*)\" and the password \"([^\\\"]*)\"$")
    public void loginIntoWebPage(String user, String password)
    {
        LoginPage login = new LoginPage();
        login.login(user,password);
    }

    @Then("^I am in the main page$")
    public void IAmInTheMainPage()
    {
        //Todo
        //MainPage main = new MainPage();
    }
}
