package ui.common;

import Framework.DriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.PageTransporter;

import java.io.FileReader;


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
        if(driver.getCurrentUrl().contains("evernote.com/Home.action"))
            return true;
        else
            return false;
    }
    public static void logOut()
    {
        PageTransporter.getInstance().goToMain().logOut();
    }

    public static void emptyAllNotes() {
        PageTransporter.getInstance()
                .goToMain()
                .getLeftMenu()
                .goToNotebooksPage()
                .goToTrash()
                .emptyAllNotes();
    }

    public static String readJsonFile(String tag) {
        String workingDir = System.getProperty("user.dir");
        JSONParser parser = new JSONParser();
        String value = "";
        try {
            Object obj = parser.parse(new FileReader(workingDir+"/config.json"));
            JSONObject jsonObject = (JSONObject) obj;
            value = (String) jsonObject.get(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
