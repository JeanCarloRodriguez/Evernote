package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * User: jeancarlorodriguez
 * Date: 11/24/15
 * Time: 7:05 PM
 */
public class ChatPage extends BasePageObject {

    @FindBy(id = "gwt-debug-arrowChatView")
    WebElement chatView;

    @FindBy(id = "gwt-debug-MessageRecipients-editContainer")
    WebElement toTextField;

    @FindBy(xpath = "//div[@id='gwt-debug-MessageRecipients-lozengeInput-lozengeTextBox']//input")
    WebElement toTextInput;

    @FindBy(id = "gwt-debug-SendMessage-message-container")
    WebElement messageTextField;

    @FindBy(id = "gwt-debug-SendMessage-message-textBox")
    WebElement messageInput;

    @FindBy(id = "gwt-debug-SendMessage-sendButton")
    WebElement sendMessageButton;

    public ChatPage()
    {
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(chatView));
    }

    public WorkChatPage sendMessageTo(String email,String message)
    {
        toTextField.click();
        toTextInput.sendKeys(email);
        messageTextField.click();
        messageInput.sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        sendMessageButton.click();
        return new WorkChatPage();
    }


}
