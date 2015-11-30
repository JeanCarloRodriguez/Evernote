package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.pages.MainPage;
import ui.pages.WorkChatPage;

/**
 * User: jeancarlorodriguez
 * Date: 11/24/15
 * Time: 7:39 PM
 */
public class WorkChat {

    static String userEmailConversation;

    @And("^I send a chat message \"([^\\\"]*)\" to \"([^\\\"]*)\"$")
    public void iSendAChatMessageTo(String message,String email)
    {
        WorkChatPage workChatPage = new WorkChatPage();
        workChatPage.startChat()
                .sendMessageTo(email, message);
        userEmailConversation = email;
    }

    @Then("^a alert message confirming that a new message was send is displayed$")
    public void aMessageConfirmingThatAMessageWasSendIsDisplayed()
    {
        WorkChatPage workChatPage = new WorkChatPage();
        MainPage mainPage = new MainPage();
        String actualResult = workChatPage.getMessageSentConfirmationText();
        //String actualResult = mainPage.getErrorMessage();
        String expectedResult = "Message sent";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @And("^a conversation with the user \"([^\\\"]*)\" is displayed in the Work Chat list$")
    public void aConversationWithTheUserIsDisplayed(String userEmail)
    {
        WorkChatPage workChatPage = new WorkChatPage();
        boolean actualResult = workChatPage.isConversationPresent(userEmail);
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Then("^the conversation with the user \"([^\\\"]*)\" is deleted in the Work Chat list$")
    public void aConversationWithTheUserIsDeleted(String userEmail)
    {
        WorkChatPage workChatPage = new WorkChatPage();
        boolean actualResult = workChatPage.isConversationDeleted(userEmail);
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @And("^the message \"([^\\\"]*)\" is displayed for the user \"([^\\\"]*)\"$")
    public void theMessageIsDisplayedForTheUser(String message, String userEmail)
    {
        WorkChatPage workChatPage = new WorkChatPage();
        boolean actualResult = workChatPage.isMessageDisplayedInConversationOverView(userEmail,message);
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("^I remove the conversation$")
    public void iRemoveTheConversation()
    {
        WorkChatPage workChatPage = new WorkChatPage();
        workChatPage.removeConversation(userEmailConversation);
    }


    @After("@removeConversation")
    public void removeConversation()
    {
        if(userEmailConversation !=null)
        {
            iRemoveTheConversation();
        }
        else
        {
            System.out.println("No user email conversation was found!! in WorkChat.java");
        }
    }
    @Given("^I go to the Work Chat tab$")
    public void iGoToTheWorkChatTab()
    {
        MainPage mainPage = new MainPage();
        mainPage.getLeftMenu().goToWorkChat();
    }

}
