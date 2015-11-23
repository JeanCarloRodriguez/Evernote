package ui;

import Framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

/**
 * Base object used for pages and components
 * Created by silvia valencia on 3/27/2015.
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the web driver, wait and web elements
     */
    public BasePageObject() {
        this.driver = DriverManager.getInstance().getWebDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract void waitUntilPageObjectIsLoaded();

    /**
     * the isPresent method returns true if the element By is present
     * otherwise return false
     */
    public boolean isPresent(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isDeleted(int numberOfTries, By by)
    {
        boolean isDeleted = false;
        int count = 0;
        while(count!=numberOfTries)
        {
            count++;
            try {
                Thread.sleep(200);
            }catch (Exception e){
                System.out.println("Sleep fails: "+e);
            }

            if(!isPresent(by)){
                isDeleted =  true;
                count= numberOfTries;
            }
        }
        return isDeleted;
    }
}
