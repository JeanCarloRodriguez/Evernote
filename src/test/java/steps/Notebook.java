package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.pages.ConfirmationPage;
import ui.pages.MainPage;
import ui.pages.NotebookPage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/12/15
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Notebook {
    MainPage mainPage;
    NotebookPage notebookPage;
    static String name;
    public Notebook(){
        mainPage = new MainPage();
    }

    @Given("I create a noteBook \"([^\\\"]*)\"")
    public void ICreateANoteBook(String noteName)
    {
        //Todo
        //make a method to now if a notebook is already exist
        //if()
        notebookPage = mainPage.getLeftMenu().goToNotebooksPage()
                .goToNewNoteBookPage()
                .createANotebook(noteName);
        name = noteName;
    }

    @Then("a notebook \"([^\\\"]*)\" is created")
    public void ANotebookIsCreated(String notebookName)
    {
        String actualResult =  notebookPage.getNotebookTitle();
        String expectedResult = notebookName;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("^I delete a notebook \"([^\\\"]*)\"$")
    public void iDeleteANotebook(String notebookName)
    {
        ConfirmationPage confirmationPage = mainPage.getLeftMenu().goToNotebooksPage()
                .deleteANotebookCalled(notebookName);
        confirmationPage.confirm();
    }

    @Then("^the notebook \"([^\\\"]*)\" is not present in the list of notebooks$")
    public void theNoteBookIsNotPresent(String notebookName)
    {
        PageTransporter.getInstance().goToMain();
        boolean actualResults= mainPage.getLeftMenu()
                .goToNotebooksPage()
                .isNotebookExist(notebookName);
        boolean expectedResult = false;

        Assert.assertEquals(actualResults,expectedResult);
    }

    @Then("^a message error is displayed at try to created a duplicate notebook name$")
    public void AMessageIsDisplayedAtTryToCreateANotebookWithTheSameName()
    {
        String actualResult = mainPage.getErrorMessage();
        String expectedResult = "The notebook title entered already exists. Please choose another title.";

        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("^I go to trash page$")
    public void iGoToTrashPage()
    {
        mainPage.getLeftMenu()
                .goToNotebooksPage()
                .goToTrash();
    }

    @After("@createNotebook")
    public void afterCreateANotebook()
    {
        if(name!=null)
            iDeleteANotebook(name);
        else
            System.out.println("there is no name to delete a notebook");
    }
}
