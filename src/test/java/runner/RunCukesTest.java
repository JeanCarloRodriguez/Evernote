package runner;

import Framework.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import ui.common.CommonMethods;
import ui.pages.MainPage;

/**
 * Created by silvia valencia on 11/9/2015.
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
//        features = {"src/test/resources/features/filebroker/ingest.feature"},
        monochrome = true)
public class RunCukesTest  extends AbstractTestNGCucumberTests {
    final static Logger logger = Logger.getLogger(RunCukesTest.class);
    @AfterTest
    public void afterExecution() {

        try {
            DriverManager.getInstance().close();
            if(CommonMethods.theAccountIsLogin())
            {
                MainPage mainPage = new MainPage();
                mainPage.logOut();
            }
        } catch (Exception e) {
            logger.error("Unable to close the driver", e);
        } finally {
            //DriverManager.getInstance().close();
        }
    }

}
