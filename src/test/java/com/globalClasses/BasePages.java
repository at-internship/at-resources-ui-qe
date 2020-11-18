package com.globalClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePages {
	private WebDriver driver;

	public BasePages(WebDriver driver){
		this.driver = driver;
	}
	public void click(By element) throws Exception {
		try {
			driver.findElement(element).click();
		}catch(Exception e){
			throw new Exception("Cannot did click at "+element);
		}
	}
	public boolean isDisplayed(By element) throws Exception {
		try {
			return driver.findElement(element).isDisplayed();
		}catch(Exception e){
			throw new Exception("The element "+element+" is not displayed");
		}
	}
	public void sendKeys(By element, String key) throws Exception {
		try {
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(key);
		}catch(Exception e){
			throw new Exception("Impossible sed keys to "+element);
		}
	}
	public void selectItem(By element) throws Exception {
		try {
			Select item = new Select(driver.findElement(element));
			if(element!=By.xpath("//div[2]//select")) {
				item.selectByIndex(((int)(Math.random()*(3-0)+1)+0));
			} else {
				item.selectByIndex(((int)(Math.random()*(6-0)+1)+0));
			}
		}catch(Exception e){
			throw new Exception("Impossible select Item: "+element);
		}
	}
	public void waitElement(By element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}catch(Exception e){
			throw new Exception("Not Found E: "+element);
		}
	}
	public String getText(By element) throws Exception {
		String text;
		try {
			text = driver.findElement(element).getText();
		}catch(Exception e){
			throw new Exception("Impossible get text to "+element);
		}
		return text;
	}

	public String getItem(By elements) throws Exception {
		try {
			String allFields = "";
			WebElement element = driver.findElement(elements);
			List<WebElement> getItemByItem = element.findElements(By.cssSelector(" tbody >tr > td"));
			for (WebElement g : getItemByItem) {
					String getItem = g.getText();
					allFields = allFields + getItem;
			};
			return allFields;
		}catch(Exception e){
			throw new Exception("Impossible select Item: "+e);
		}
	}
	public String clickPagination(By elements, By items) throws Exception {
		String allItems = "";
		WebElement nextElement = driver.findElement(elements);
		String lastElement = nextElement.getAttribute("class");
		do  {
			nextElement = driver.findElement(elements);
			lastElement = nextElement.getAttribute("class");
			allItems = allItems + getItem(items);
			nextElement.click();
		} while (!lastElement.contains("disabled"));
		return allItems;
	}
}