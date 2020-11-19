package com.globalClasses;

import org.openqa.selenium.WebDriver;
import com.stepdefinitions.Hooks;

public class TestBase {
	protected WebDriver driver = Hooks.getDriver();
	protected BasePages base = new BasePages(driver);
	protected GetAllStories usersAP = new GetAllStories();
	protected DeleteByStory deleteAP = new DeleteByStory();
	protected TestValues values = new TestValues();
	protected StoriesAdmonPage storiesAP = new StoriesAdmonPage();
	protected AddNewStoryPage addNSP = new AddNewStoryPage();
}