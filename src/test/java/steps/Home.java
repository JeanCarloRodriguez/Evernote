package steps;

import Framework.DriverManager;
import cucumber.api.java.en.Given;
import ui.PageTransporter;
import ui.pages.HomePage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/10/15
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home {
    HomePage homePage;

    public Home()
    {
        homePage = new HomePage();
    }

    @Given("^I go to the root Page$")
    public void IAmInTheRootPage()
    {
        PageTransporter.getInstance().goToRoot();
    }

    @Given("^I Go to the log in Page$")
    public void goToLoginPage()
    {
        homePage.goToLoginPage();
    }
}
