package steps.hooks;

import Framework.DriverManager;
import cucumber.api.java.After;
import ui.common.CommonMethods;
import ui.pages.MainPage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/16/15
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class GlobalHooks {
    MainPage mainPage;
    public GlobalHooks()
    {
        mainPage = new MainPage();
    }
    /*TODO after all method
    @After(order = 1)
    public void lastScenarioOfFeature()
    {
        if(CommonMethods.theAccountIsLogin())
        {
            mainPage.getLeftMenu().logOut();
        }
        DriverManager.getInstance().close();
    }
    */
}
