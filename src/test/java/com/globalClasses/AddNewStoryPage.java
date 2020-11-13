package com.globalClasses;

import org.openqa.selenium.By;

public class AddNewStoryPage {
	private By addStoryTitleLocator = By.xpath("//h3[contains(string(),'New Story')]");
	private By sprintLocator = By.xpath("//div[2]//select");
	private By userLocator = By.xpath("//div[3]//select");
	private By priorityLocator = By.xpath("//div[4]//select");
	private By nameLocator = By.name("name");
	private By descriptionLocator = By.name("description");
	private By acceptanceLocator = By.name("ac");
	private By storyPointsLocator = By.xpath("//div[6]//select");
	private By startDateLocator = By.xpath("//div[7]/input[1]");
	private By dueDateLocator = By.xpath("//div[7]/input[2]");
	private By submitLocator = By.xpath("//button[@type='submit']");

	public By getAddStoryTitleLocator() {
		return addStoryTitleLocator;
	}
	public By getSprintLocator() {
		return sprintLocator;
	}
	public By getUserLocator() {
		return userLocator;
	}
	public By getPriorityLocator() {
		return priorityLocator;
	}
	public By getNameLocator() {
		return nameLocator;
	}
	public By getDescriptionLocator() {
		return descriptionLocator;
	}
	public By getAcceptanceLocator() {
		return acceptanceLocator;
	}
	public By getStoryPointsLocator() {
		return storyPointsLocator;
	}
	public By getStartDateLocator() {
		return startDateLocator;
	}
	public By getDueDateLocator() {
		return dueDateLocator;
	}
	public By getSubmitLocator() {
		return submitLocator;
	}
}