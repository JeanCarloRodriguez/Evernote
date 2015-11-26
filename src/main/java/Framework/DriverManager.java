package Framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/9/15
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DriverManager {
    private static DriverManager instance;
    private static WebDriver driver;
    private static WebDriverWait wait;

    final static Logger logger = Logger.getLogger(DriverManager.class);

    protected DriverManager(){
    }

    public static DriverManager getInstance()
    {
        if(instance == null)
        {
            instance = new DriverManager();
            if(driver == null)
            {
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                //driver = new ChromeDriver();
                driver = new FirefoxDriver();
                logger.info("initializing the driver");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("https://www.evernote.com/");
            }
            if(wait == null)
            {
                wait = new WebDriverWait(driver,20);
            }

        }
        return instance;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void quit()
    {
        driver.quit();
        driver = null;
    }
}
