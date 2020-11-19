package com.globalClasses;

import org.openqa.selenium.By;

public class AddNewStoryPage {
	private By addStoryTitleLocator = By.xpath("//h3[contains(string(),'New Story')]");
	private By sprintLocator = By.id("story_sprintId");
	private By userLocator = By.id("story_userId");
	private By priorityLocator = By.id("story_priority");
	private By nameLocator = By.id("story_name");
	private By descriptionLocator = By.id("story_description");
	private By acceptanceLocator = By.id("story_acceptanceCriteria");
	private By storyPointsLocator = By.id("story_storyPoints");
	private By progressLocator = By.id("story_progress");
	private By startDateLocator = By.id("story_startDate");
	private By dueDateLocator = By.id("story_dueDate");
	private By statusLocator = By.id("story_status");
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
	public By getProgressLocator() {
		return progressLocator;
	}
	public By getStartDateLocator() {
		return startDateLocator;
	}
	public By getDueDateLocator() {
		return dueDateLocator;
	}
	public By getStatusLocator() {
		return statusLocator;
	}
	public By getSubmitLocator() {
		return submitLocator;
	}
}