package steps;

import Framework.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.pages.LeftMenuPage;
import ui.pages.MainPage;
import ui.pages.NotebookPage;
import ui.pages.NotesPage;

/**
 * Created with IntelliJ IDEA.
 * User: jeancarlorodriguez
 * Date: 11/14/15
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Note {
    MainPage mainPage;
    LeftMenuPage leftMenuPage;
    NotebookPage notebookPage;
    NotesPage notesPage;
    String name;
    public Note()
    {
        mainPage = new MainPage();
    }
    @When("^I create a note \"([^\\\"]*)\" for notebook \"([^\\\"]*)\"$")
    public void ICreateANote(String noteName,String notebookName)
    {
        leftMenuPage = mainPage.getLeftMenu();
        leftMenuPage.goToNewNotePage()
                .createNote(noteName,notebookName);

    }
    @Then("^The note \"([^\\\"]*)\" is in the note list of \"([^\\\"]*)\" notebook$")
    public void theNoteIsInTheNoteListOfTheNotebook(String noteName,String notebookName)
    {
        notebookPage = new NotebookPage();
        boolean actualResult = notebookPage.isNoteExist(noteName);
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("^I delete the note \"([^\\\"]*)\"$")
    public void iDeleteANoteFromTheNoteList(String noteName)
    {
        notesPage = mainPage.getLeftMenu().goToNotesPage().deleteNote(noteName).delete();
        name = noteName;
    }
    @Then("^the note \"([^\\\"]*)\" is not displayed in the list of notes$")
    public void theNoteIsNotInTheList(String noteName)
    {
        boolean actualResult = notesPage.isNoteExist(noteName);
        boolean expectedResult = false;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Then("^a message confirming that a note was deleted is displayed$")
    public void aMessageConfirmingThatANoteWasDeleted()
    {
        String actualResult = notesPage.getDeleteMessage();
        String expectedResult = name+" "+"moved to Trash.";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
