package com.globalClasses;

import org.openqa.selenium.By;

public class GetAllStories {
    private By getStoryByStory = By.id("storiesTable");
    private By getPages = By.id("storiesTable_next");
    private By entries = By.name("storiesTable_length");

    public By getStories() {return getStoryByStory;}
    public By nextPage() {return getPages;}
    public By getEntries() {return entries;}
}