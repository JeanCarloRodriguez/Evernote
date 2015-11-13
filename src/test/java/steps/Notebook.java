package steps;

import cucumber.api.java.en.Given;
import org.testng.Assert;
import ui.pages.LeftMenuPage;
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
    LeftMenuPage leftMenuPage;
    NotebookPage notebookPage;
    public Notebook(){
        mainPage = new MainPage();
        //leftMenuPage = new LeftMenuPage();
    }

    @Given("I have a noteBook called \"([^\\\"]*)\"")
    public void IHaveANoteBook(String name)
    {
        leftMenuPage = mainPage.getLeftMenu();
        notebookPage = leftMenuPage.goToNotebookPage()
                .goToNewNoteBookPage()
                .createANotebook(name);
        System.out.println("the name of the notebook: "+notebookPage.getNotebookTitle());
        Assert.assertEquals(name,notebookPage.getNotebookTitle());
        System.out.println("work until here");
    }
}
