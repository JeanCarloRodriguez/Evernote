package steps;

import cucumber.api.java.en.When;
import ui.pages.LeftMenuPage;
import ui.pages.MainPage;
import ui.pages.NotebookPage;

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
    public Note()
    {
        mainPage = new MainPage();
    }
    @When("^I create a note called \"([^\\\"]*)\" in \"([^\\\"]*)\" notebook$")
    public void ICreateANote(String noteName,String notebookName)
    {
        leftMenuPage = mainPage.getLeftMenu();
        leftMenuPage.goToNewNotePage()
                .createNote(noteName,notebookName);

    }
}
