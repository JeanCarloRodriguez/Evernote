package ui;

import Framework.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;

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
    private static PageTransporter instance;

    public PageTransporter()
    {
        rootUrl = "https://evernote.com";
        mainUrl = "https://www.evernote.com/Home.action";
    }

    public static PageTransporter getInstance()
    {
        if(instance==null)
        {
            instance = new PageTransporter();
        }
        return instance;
    }


    public void goToRoot()
    {
        driver.get(rootUrl);
    }
    public MainPage goToMain()
    {
        driver.get(mainUrl);
        return new MainPage();
    }
}
