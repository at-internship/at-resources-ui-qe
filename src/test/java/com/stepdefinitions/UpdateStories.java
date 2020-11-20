package com.stepdefinitions;

import com.globalClasses.MongoDBUtils;
import com.globalClasses.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateStories extends TestBase{
	String data1, data2, id, monData1, monData2;
	
	@Given("I select a random story to edit")
	public void i_select_a_random_story_to_edit() throws Throwable {
		id = MongoDBUtils.getRandomID("TEST", "at-resources-db", "stories");
		base.sendKeys(storiesAP.getSearchLocator(), id);
		data1 = base.getText(storiesAP.getDataInTableLocator(id));
		monData1 = MongoDBUtils.getJObjectByID("TEST", "at-resources-db", "stories", id);
	}
	
	@When("I do click in the Edit Story button")
	public void i_do_click_in_the_Edit_Story_button() throws Throwable {
		base.click(storiesAP.getPlusButtonLocator(id));
		base.click(storiesAP.getEditInRowLocator(id));
	}

	@Then("The EditStory form should be displayed")
	public void the_EditStory_form_should_be_displayed() throws Throwable {
		base.waitElement(eSP.getEditStoriesTitleLocator());
		base.waitElement(eSP.getSubmitLocator());
	}
	
	@Given("I put a new name")
	public void i_put_a_new_name() throws Throwable {
		base.sendKeys(eSP.getNameLocator(), values.randomName());
	}
	
	@When("I do click in the Update button")
	public void i_do_click_in_the_Update_button() throws Throwable {
		base.click(eSP.getSubmitLocator());
	}
	
	@Then("I should see an alert of successful story Update")
	public void i_should_see_an_alert_of_successful_story_Update() throws Throwable {
		base.waitElement(storiesAP.getSuccessLocator());
	}
	
	@Then("I should see the changes in the Stories Module")
	public void i_should_see_the_changes_in_the_Stories_Module() throws Throwable {
		base.sendKeys(storiesAP.getSearchLocator(), id);
		data2 = base.getText(storiesAP.getDataInTableLocator(id));
		assert false == data1.equals(data2);
	}
	
	@Then("I should see the changes in the Mongo DB")
	public void i_should_see_the_changes_in_the_Mongo_DB() throws Throwable {
		monData2 = MongoDBUtils.getJObjectByID("TEST", "at-resources-db", "stories", id);
		assert false == monData1.equals(monData2);
	}
}
