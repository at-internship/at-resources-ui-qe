package com.globalClasses;

import org.openqa.selenium.By;

public class StoriesAdmonPage {
	private By storiesAdmonTitleLocator = By.xpath("//h4[contains(string(),'Stories Module')]");
	private By addStoryButtonLocator = By.linkText("» Add New Story");
	private By successLocator = By.xpath("//div/div[contains(string(),'Successfully')]");
	private By scearchingBarLocator = By.xpath("//input");
	private By firstIDInTableLocator = By.xpath("//tr[1]/td[1][contains(string(),'5f')]");
	private By dataInTableLocator;
	private String a = "//td[contains(string(),'", b="')]";

	public By getStoriesAdmonTitleLocator() {
		return storiesAdmonTitleLocator;
	}
	public By getAddStoryButtonLocator() {
		return addStoryButtonLocator;
	}
	public By getSuccessLocator() {
		return successLocator;
	}
	public By getScearchingBarLocator() {
		return scearchingBarLocator;
	}
	public By getFirstIDInTableLocator() {
		return firstIDInTableLocator;
	}
	public By getDataInTableLocator(String data) {
		dataInTableLocator = By.xpath(a+data+b);
		return dataInTableLocator;
	}
}