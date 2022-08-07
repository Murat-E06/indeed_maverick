package com.indeed.uk.pages;

import com.indeed.uk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobDetailPage extends BasePage{

    public JobDetailPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//ul[@class='jobsearch-ResultsList css-0']//td[@class='resultContent']//h2")
    public List<WebElement> jobLists;

    public String getTextOfElement(WebElement element){
        return element.getText();
    }
    public String getTextOfElements(List<WebElement> elements) {
        String result="";
        for (WebElement each : elements) {
            result+=getTextOfElement(each)+"\n";
        }
        return result;
    }






}
