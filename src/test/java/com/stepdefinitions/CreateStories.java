package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.globalClasses.MongoDBUtils;
import com.globalClasses.TestBase;

public class CreateStories extends TestBase {
	String name;

	@Given("I am in the Stories Administration page")
	public void i_am_in_the_Stories_Administration_page() throws Throwable {
		driver.get("https://at-resources-ui.herokuapp.com/admin/story");
		base.waitElement(storiesAP.getStoriesAdmonTitleLocator());
	}

	@When("I do click in the AddNewStory button")
	public void i_do_click_in_the_AddNewStory_button() throws Throwable {
		base.click(storiesAP.getAddStoryButtonLocator());
	}

	@Then("The AddNewStory form should be displayed")
	public void the_AddNewStory_form_should_be_displayed() throws Throwable {
		base.waitElement(addNSP.getAddStoryTitleLocator());
	}

	@Given("I select a sprint")
	public void i_select_a_sprint() throws Throwable {
		base.selectItem(addNSP.getSprintLocator());
	}

	@Given("I select a user")
	public void i_select_a_user() throws Throwable {
		base.selectItem(addNSP.getUserLocator());
	}

	@Given("I select a priority")
	public void i_select_a_priority() throws Throwable {
		base.selectItem(addNSP.getPriorityLocator());
	}

	@Given("I put a name")
	public void i_put_a_name() throws Throwable {
		name = values.randomName();
		base.sendKeys(addNSP.getNameLocator(), name);
	}

	@Given("I put a description")
	public void i_put_a_description() throws Throwable {
		base.sendKeys(addNSP.getDescriptionLocator(), values.randomString());
	}

	@Given("I put acceptance criteria")
	public void i_put_acceptance_criteria() throws Throwable {
		base.sendKeys(addNSP.getAcceptanceLocator(), values.randomString());
	}

	@Given("I assign story points")
	public void i_assign_story_points() throws Throwable {
		base.selectItem(addNSP.getStoryPointsLocator());
	}

	@Given("I select a start date")
	public void i_select_a_start_date() throws Throwable {
		base.sendKeys(addNSP.getStartDateLocator(), values.randomStartDate());
	}

	@Given("I select a due date")
	public void i_select_a_due_date() throws Throwable {
		base.sendKeys(addNSP.getDueDateLocator(), values.randomDueDate());
	}

	@When("I do click in the Save button")
	public void i_do_click_in_the_Save_button() throws Throwable {
		base.click(addNSP.getSubmitLocator());
	}

	@Then("I should see an alert of successful story creation")
	public void i_should_see_an_alert_of_successful_story_creation() throws Throwable {
		base.waitElement(storiesAP.getSuccessLocator());
	}

	@Then("The story should be found by the search function of the page")
	public void the_story_should_be_found_by_the_search_function_of_the_page() throws Throwable {
		base.sendKeys(storiesAP.getScearchingBarLocator(), name);
		base.isDisplayed(storiesAP.getDataInTableLocator(name));
	}

	@Then("The story should be found in the DB")
	public void the_story_should_be_found_in_the_DB() throws Throwable {
		String id = base.getText(storiesAP.getFirstIDInTableLocator());
		assert true == MongoDBUtils.existID("TEST", "at-resources-db", "stories", id);
	}
}