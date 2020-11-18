package com.globalClasses;

import org.openqa.selenium.By;

public class GetAllStories {
    private By getStoryByStory = By.id("storiesTable");
    private By getPages = By.id("storiesTable_next");

    public By getStories() {return getStoryByStory;}
    public By nextPage() {return getPages;}
}