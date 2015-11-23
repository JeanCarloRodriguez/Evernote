package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.pages.TrashPage;

/**
 * User: jeancarlorodriguez
 * Date: 11/21/15
 * Time: 2:55 PM
 */
public class Trash {

    @When("^I empty all the notes$")
    public void iEmptyAllTheNotes()
    {
        TrashPage trashPage = new TrashPage();
        trashPage.emptyAllNotes();
    }

    @Then("^the trash is empty$")
    public void theTrashIsEmpty()
    {
        TrashPage trashPage = new TrashPage();
        Assert.assertEquals(trashPage.isEmpty(),true);
        System.out.println("the trash haves: "+trashPage.getNotesCount());
    }

    @And("^the notes count says \"([^\\\"]*)\"$")
    public void theNotesCountSays(String noteCounts)
    {
        TrashPage trashPage = new TrashPage();
        String actualResult = trashPage.getNotesCount();
        Assert.assertEquals(actualResult,noteCounts);
    }


}
