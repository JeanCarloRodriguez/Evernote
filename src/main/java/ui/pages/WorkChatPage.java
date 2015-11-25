package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: jeancarlorodriguez
 * Date: 11/24/15
 * Time: 6:58 PM
 */
public class WorkChatPage extends BasePageObject {

    @FindBy(id = "gwt-debug-workChatDrawerDrawerSlidingPanel")
    WebElement slidingPanel;

    @FindBy(id = "gwt-debug-WorkChatDrawer-startChatButton")
    WebElement startChatButton;

    public WorkChatPage()
    {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(slidingPanel));
    }

    public ChatPage startChat()
    {
        startChatButton.click();
        return new ChatPage();
    }

    public String getMessageSentConfirmationText()
    {
        WebElement confirmationText = driver.findElement(By.xpath("//div[@id='gwt-debug-workChatToast']//div[text()='Message sent']"));
        return confirmationText.getText();
    }
}
