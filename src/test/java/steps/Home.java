package steps;

import Framework.DriverManager;
import cucumber.api.java.en.Given;
import ui.pages.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/10/15
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home {

    @Given("^I Go to the log in Page$")
    public void goToLoginPage()
    {
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();
    }
}
