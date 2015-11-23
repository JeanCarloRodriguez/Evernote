package ui;

import Framework.DriverManager;
import org.openqa.selenium.WebDriver;
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
    private WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static String rootUrl;
    private static String mainUrl;
    private static String loginUrl;
    private static PageTransporter instance;

    private PageTransporter()
    {
        rootUrl = "https://evernote.com";
        mainUrl = "https://www.evernote.com/Home.action";
        loginUrl = "https://www.evernote.com/Login.action";
    }

    public static PageTransporter getInstance()
    {
        if(instance==null)
        {
            instance = new PageTransporter();
        }
        return instance;
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
