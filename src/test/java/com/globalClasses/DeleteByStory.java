package com.globalClasses;

import org.openqa.selenium.By;

public class DeleteByStory {
    private By successDelete = By.xpath("//div/div[contains(string(),'Story Deleted Successfully')]");
    private By confirmElimination;
    private String a = "//td[contains(.,'", b="')]";

    public By getSuccessDelete() {
        return successDelete;
    }
    public By confirmElimination(String data) {
        confirmElimination = By.xpath(a+data+b);
        return confirmElimination;
    }
}
