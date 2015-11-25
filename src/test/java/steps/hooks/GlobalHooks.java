package steps.hooks;

import Framework.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/16/15
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class GlobalHooks {
    WebDriver webDriver = DriverManager.getInstance().getWebDriver();
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("********************************************************************************************************************************");
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png"); // ... and embed it in the report.
            System.out.println("the Scenario: "+ scenario.getName()+" Failed!!!!");
        }
    }
}
