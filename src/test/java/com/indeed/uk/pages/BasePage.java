package com.indeed.uk.pages;

import com.indeed.uk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() { //Constructor oluşturduk, this:in order to call current class' instance(örnek) of object
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="text-input-what")
    public WebElement whatBox;

    @FindBy(id="text-input-where")
    public WebElement whereBox;

    @FindBy(xpath = "//button[@class='yosegi-InlineWhatWhere-primaryButton']")
    public WebElement findJobsButton;

    @FindBy(xpath = "//div[@id='searchCountPages']")
    public WebElement numberOfJobs;

    @FindBy(xpath = "//button[@id='filter-radius']")
    public WebElement radiusButton;

    @FindBy(xpath = "//ul[@id='filter-radius-menu']//a")
    public List<WebElement> radiusList;






}
