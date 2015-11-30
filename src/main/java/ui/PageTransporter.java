package ui;

import Framework.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.common.CommonMethods;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.RootPage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/14/15
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageTransporter {
    private static WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static String rootUrl;
    private static String mainUrl;
    private static String loginUrl;
    private static PageTransporter instance;

    private PageTransporter()
    {
        rootUrl = CommonMethods.readJsonFile("rootUrl");
        mainUrl = CommonMethods.readJsonFile("mainUrl");
        loginUrl = CommonMethods.readJsonFile("loginUrl");
    }

    public static PageTransporter getInstance()
    {
        if(instance==null)
        {
            instance = new PageTransporter();
        }
        return instance;
    }

    public static boolean theAccountIsLogged()
    {
        if(driver.getCurrentUrl().contains(CommonMethods.readJsonFile("loggedUrl")))
            return true;
        else
            return false;
    }

    public RootPage goToRoot()
    {
        driver.get(rootUrl);
        return new RootPage();
    }
    public MainPage goToMain()
    {
        driver.get(mainUrl);
        return new MainPage();
    }
    public LoginPage goToLogin()
    {
        driver.get(loginUrl);
        return new LoginPage();
    }
    public String getMainUrl()
    {
        return mainUrl;
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
