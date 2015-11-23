package steps;

import cucumber.api.java.en.Given;
import ui.PageTransporter;
import ui.pages.RootPage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/10/15
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home {
    RootPage rootPage;

    @Given("^I go to the root Page$")
    public void iGoToTheRootPage()
    {
        rootPage = PageTransporter.getInstance().goToRoot();
    }

    @Given("^I Go to the log in Page$")
    public void goToLoginPage()
    {
        rootPage.goToLoginPage();
    }
}
