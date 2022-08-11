package com.indeed.uk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://uk.indeed.com/
public class UkIndeedPage {
    @FindBy(xpath = "//span[contains(@class, 'attribute_snippet')]")
    public WebElement salary;

    @FindBy(xpath = "//div[text()='Warrington']")
    public WebElement city;

    @FindBy(xpath = "//div[contains(@class, 'icl-u-xs-mt--md')]")
    public WebElement jobsDescription;

 

    // No page elements added

    public UkIndeedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}