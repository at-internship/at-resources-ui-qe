package com.globalClasses;

import org.openqa.selenium.By;

public class StoriesAdmonPage {
	private By storiesAdmonTitleLocator = By.xpath("//h4[contains(string(),'Stories Module')]");
	private By addStoryButtonLocator = By.linkText("» Add New Story");
	private By successLocator = By.xpath("//div/div[contains(string(),'Successfully')]");
	private By dataInTableLocator;
	private By editInRowLocator;
	private String a = "//tr[contains(string(),'", b="')]";
	private String c="//a[@href='/admin/story/edit/", d="']";

	public By getStoriesAdmonTitleLocator() {
		return storiesAdmonTitleLocator;
	}
	public By getAddStoryButtonLocator() {
		return addStoryButtonLocator;
	}
	public By getSuccessLocator() {
		return successLocator;
	}
	public By getDataInTableLocator(String data) {
		dataInTableLocator = By.xpath(a+data+b);
		return dataInTableLocator;
	}
	public By getEditInRowLocator(String id) {
		editInRowLocator = By.xpath(c+id+d);
		return editInRowLocator;
	}
}