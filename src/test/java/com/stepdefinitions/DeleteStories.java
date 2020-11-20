package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.domain.uiDelete;

import com.globalClasses.TestBase;

public class DeleteStories extends TestBase {
    uiDelete ui = new uiDelete();

    @Given("I have an existent id")
    public void i_have_an_existent_id() throws Exception {
        ui.setId(base.getFirstId(usersAP.getStories()));
    }

    @When("I delete a existent story on the dashboard")
    public void i_delete_a_existent_story_on_the_dashboard() throws Exception {
    	base.click(storiesAP.getPlusButtonLocator(ui.getId()));
    	base.click(storiesAP.getDeleteInRowLocator(ui.getId()));
    	//base.deleteFirstStory(usersAP.getStories());
    }
    @Then("I should see an alert of successful story deleted")
    public void i_should_see_an_alert_of_successful_story_deleted() throws Exception {
        base.waitElement(deleteAP.getSuccessDelete());
    }
    @Then("I verify in the dashboard if the story does not exist")
    public void i_verify_in_the_dashboard_if_the_story_does_not_exist() throws Exception {
        base.sendKeys(storiesAP.getSearchLocator(), ui.getId());
    	assert true == base.isNotDisplayed(deleteAP.confirmElimination(ui.getId()));
    }

}
