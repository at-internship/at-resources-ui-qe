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

	public boolean isNotDisplayed(By element) throws Exception {
		try {
			driver.findElement(element).isDisplayed();
			return false;
		}catch(Exception e){
			return true;
		}
  }

	public void sendKeys(By element, String key) throws Exception {
		try {
			driver.findElement(element).clear();
      driver.findElement(element).sendKeys(key);
		}catch(Exception e){
			throw new Exception("Impossible send keys to " + element);
		}
	}
	
	public void changeEntries(By element) throws Exception{
		try {
			Select item = new Select(driver.findElement(element));
			item.selectByIndex(3);
		} catch(StaleElementReferenceException e) {
			throw new Exception("Imposible select Item: "+e);
		}
		}

	public void selectItem(By element) throws Exception {
		try {
			driver.findElement(element).click();
			Select item = new Select(driver.findElement(element));
			if(element.equals(By.id("story_sprintId"))) {
				item.selectByIndex(((int)(Math.random()*(6-0)+1)+0));
			} else if(element.equals(By.id("story_storyPoints"))){
				item.selectByIndex(((int)(Math.random()*(5-0)+1)+0));
			} else if(element.equals(By.id("story_status"))) {
				item.selectByIndex(((int)(Math.random()*(2-0)+1)+0));
			} else {
				item.selectByIndex(((int)(Math.random()*(3-0)+1)+0));
			}
		}catch(Exception e){
			throw new Exception("Impossible select Item: "+element);
		}
	}
	public void waitElement(By element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
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

	public String getFirstId(By items) throws Exception {
		try {
			String firstId = "";
			int counter = 0;

			WebElement element = driver.findElement(items);
			List<WebElement> getItemByItem = element.findElements(By.cssSelector(" tbody >tr > td"));

			for (WebElement g : getItemByItem) {
				if (counter == 0){
					String getItem = g.getText();
					firstId = firstId + getItem;
				}else{
					break;
				}
				counter = counter + 1;
			};
			return firstId;
		}catch(Exception e){
			throw new Exception("Impossible select Item: "+ e);
		}
	}


	public String getItem(By elements) throws Exception {
		try {
			String allFields = "";
			String getItem = "";
			clickPlusInfo(elements);
			WebElement element = driver.findElement(elements);
			List<WebElement> getItemByItem = element.findElements(By.cssSelector(" tbody >tr > td"));
			for (WebElement g : getItemByItem) {
				if(g.getAttribute("class").contains("child")) {
					List<WebElement> getHidenItemByItem = g.findElements(By.cssSelector("ul > li > span")); 
					for(WebElement s : getHidenItemByItem) {
						if(s.getAttribute("class").contains("dtr-data")) {
							getItem = s.getText();
							allFields = allFields + getItem;
						}
					}
				}else {
					getItem = g.getText();
					allFields = allFields + getItem;
				}
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
	
	public void clickPlusInfo(By elements) throws Exception {
		if(driver.findElement(By.xpath("//*[@id=\"storiesTable\"]/tbody/tr[1]/td[1]")).isDisplayed()) {
			WebElement element = driver.findElement(elements);
			List<WebElement> getButtonByButton = element.findElements(By.xpath("//*[@class='sorting_1']"));
			for (WebElement c : getButtonByButton) {
				c.click();
			}
		}
	}
}