package com.indeed.uk.pages;

import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobDetailPage extends BasePage {

    public JobDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='jobsearch-ResultsList css-0']//td[@class='resultContent']//h2")
    public List<WebElement> jobList;

    @FindBy(xpath = "//ul[@class='pagination-list']/li/a")
    public List<WebElement> pageNumberList;

    //job details locators

    @FindBy(xpath = "//div[@class='jobsearch-JobInfoHeader-title-container ']/h1")
    public WebElement jobDetailName;

    @FindBy(xpath = "//div[@id='salaryInfoAndJobType']")
    public WebElement jobDetailSalary;

    /////////////////////////////////////////////////////////


    @FindBy(xpath = "//div[@class='job_seen_beacon']")
    public List<WebElement> firstPageJobBoxesAreas;

    @FindBy(xpath = "//div[@id='jobDescriptionText']")
    public WebElement jobDescriptionText;

    @FindBy(xpath = "//div[@id='jobDescriptionText']/b")
    public List<WebElement> jobDescriptionTextList;

    @FindBy(xpath = "//div[@class='metadata salary-snippet-container']")
    public List<WebElement> salaryList;





//////////////////////////////////////////////////////////////////////////
    public String getTextOfElement(WebElement element) {
        return element.getText();
    }

    public String getTextOfElements(List<WebElement> elements) {
        String result = "";
        for (WebElement each : elements) {
            result += getTextOfElement(each) + "\n";
        }
        return result;
    }

    public String getTextOfAllPagesElements(List<WebElement> elements) {

        String allElements = "";

        if (BrowserUtils.webElementExists(pageNumberList)) {
            for (int i = 1; i < pageNumberList.size(); i++) { // changed

                BrowserUtils.waitFor(10);
                allElements += getTextOfElements(jobList);
                System.out.println("allElements  with " + i + " page:\n " + allElements);

                BrowserUtils.waitFor(10); // changed rom 5 to 10
                BrowserUtils.waitForClickablility(pageNumberList.get(0),10);
                pageNumberList.get(pageNumberList.size() - 1).click();  // click last one > next button


            }
        } else {
            BrowserUtils.waitFor(10);
            allElements += getTextOfElements(jobList);
            System.out.println("allElements  only one page= " + allElements);

        }
        return allElements;
    }

    public String getTextOfAllPagesWithWhileLoop(List<WebElement> elements) {

        String allElements = "";

        // gets names of the jobs from first page
        BrowserUtils.waitFor(10);
        allElements += getTextOfElements(jobList);
        System.out.println("allElements  first page= " + allElements);

        // gets names from other pages if any
        if ((BrowserUtils.webElementExists(pageNumberList))) {

            int i = 2; // starting from page to

            int numberOfPages = pageNumberList.size(); // ending last page

            while (i <= numberOfPages ){

                // Javascript executor
                //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");


                BrowserUtils.waitFor(10);
                // last element is  (next) > button which has the index of size-1
                pageNumberList.get(numberOfPages-1).click();

                BrowserUtils.waitFor(10);
                allElements += getTextOfElements(jobList);
                System.out.println("allElements  with " + ++i + " page= " + allElements);

            }
        }

        return allElements;
    }
}
