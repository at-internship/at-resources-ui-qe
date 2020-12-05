package com.stepdefinitions;

import com.globalClasses.MongoDBUtils;
import com.globalClasses.TestBase;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class GetStories extends TestBase{
    String allStories = "";

    @When("I compare mongo with stories displayed")
    public void i_compare_mongo_with_stories_displayed() throws Exception {
    	base.changeEntries(usersAP.getEntries());
        allStories = base.clickPagination(usersAP.nextPage(), usersAP.getStories());
    }
    @Then("I validate the mongodb data and the stories")
    public void i_validate_the_mongodb_data_and_the_stories() {
        assert true == MongoDBUtils.compareAllJsonString("TEST", "at-resources-db", "stories", allStories);
    }
}