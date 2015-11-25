package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import ui.pages.MainPage;
import ui.pages.WorkChatPage;

/**
 * User: jeancarlorodriguez
 * Date: 11/24/15
 * Time: 7:39 PM
 */
public class WorkChat {

    @And("^I send a chat message \"([^\\\"]*)\" to \"([^\\\"]*)\"$")
    public void iSendAChatMessageTo(String message,String email)
    {
        MainPage mainPage = new MainPage();
        mainPage.getLeftMenu().goToWorkChat()
                .startChat()
                .sendMessageTo(email,message);
    }

    @Then("^a message confirming that a message was send is displayed$")
    public void aMessageConfirmingThatAMessageWasSendIsDisplayed()
    {
        WorkChatPage workChatPage = new WorkChatPage();
        MainPage mainPage = new MainPage();
        //String actualResult = workChatPage.getMessageSentConfirmationText();
        String actualResult = mainPage.getErrorMessage();
        String expectedResult = "Message sent";
        Assert.assertEquals(actualResult,expectedResult);
    }

}
