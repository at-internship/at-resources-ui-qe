package com.globalClasses;

import org.openqa.selenium.By;

public class EditStoriesPage {
	private By editStoriesTitleLocator = By.xpath("//h3[contains(string(),'Edit Story')]");
	private By nameLocator = By.id("story_name");
	private By submitLocator = By.xpath("//button[@type='submit']");
	
	public By getEditStoriesTitleLocator() {
		return editStoriesTitleLocator;
	}
	public By getNameLocator() {
		return nameLocator;
	}
	public By getSubmitLocator() {
		return submitLocator;
	}
}
