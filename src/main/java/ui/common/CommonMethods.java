package ui.common;

import Framework.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.PageTransporter;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/12/15
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommonMethods {

    public static void elementHighlight(WebElement element) {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: red; border: 3px solid red;");
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
        }
    }
    public static boolean theAccountIsLogin()
    {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        PageTransporter.getInstance().goToLogin();
        if(driver.getCurrentUrl().contains("login=true"))
            return true;
        else
            return false;
    }
}
