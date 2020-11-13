package com.globalClasses;

import org.openqa.selenium.WebDriver;
import com.stepdefinitions.Hooks;

public class TestBase {
	protected WebDriver driver = Hooks.getDriver();
	protected BasePages base = new BasePages(driver);
	protected TestValues values = new TestValues();
	protected StoriesAdmonPage storiesAP = new StoriesAdmonPage();
	protected AddNewStoryPage addNSP = new AddNewStoryPage();
}