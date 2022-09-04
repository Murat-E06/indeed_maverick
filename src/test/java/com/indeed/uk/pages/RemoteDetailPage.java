package com.indeed.uk.pages;

import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.Driver;
import com.indeed.uk.utilities.ExcelUtil;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class RemoteDetailPage extends JobDetailPage {

    public RemoteDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='filter-remotejob']")
    public WebElement remoteButton;

    @FindBy(xpath = "//ul[@id='filter-remotejob-menu']")
    public List<WebElement> remoteSelection;

    @FindBy(xpath = "//ul[@class='jobsearch-ResultsList css-0']//td[@class='resultContent']//h2/a")
    public List<WebElement> jobLinks;

    public WebElement getRemoteOption(String choice) {
        if (choice.startsWith("R") || choice.startsWith("r")) {
            return remoteSelection.get(0);
        } else {
            return remoteSelection.get(1);
        }
    }

    //print excel list
    @Test
    public void printExcel(String fileName, int pageNumber) {
        for (int i = 1; i <= pageNumber; i++) {

            ExcelUtil excelFile = new ExcelUtil("src/test/resources/data/"+fileName, "Page"+i);

            System.out.println("Printing page "+i);

            //method for returning list of map
            List<Map<String, String>> dataList = excelFile.getDataList();
            for (Map<String, String> rowmap : dataList) {
                System.out.println(rowmap);
            }
        }
    }

    // put given list to excel
    public void putTexttoExcel(List<WebElement> elements, String fileName,String columnName, String page) {

        ExcelUtil excelFile = new ExcelUtil("src/test/resources/data/"+fileName, page);

        for (int i = 0; i < elements.size(); i++) {
            String text;
            if (columnName.equals("Name")) {
                text = elements.get(i).getText();
            } else {
                text = elements.get(i).getAttribute("href");
            }
            excelFile.setCellData(text, columnName, i + 1);

        }

    }

    // Check all pages and puts them in excel
    public void putTextOfAllPagestoExcel(List<WebElement> elements, String fileName) {

        if (BrowserUtils.webElementExists(pageNumberList)) {
            for (int i = 1; i < pageNumberList.size(); i++) { // changed

                BrowserUtils.waitFor(10);
                putTexttoExcel(jobList, fileName,"Name", "Page" + i);

                putTexttoExcel(jobLinks, fileName,"List", "Page" + i);


                BrowserUtils.waitFor(10); // changed rom 5 to 10
                BrowserUtils.waitForClickablility(pageNumberList.get(0), 10);
                pageNumberList.get(pageNumberList.size() - 1).click();  // click last one > next button

            }
        } else {
            BrowserUtils.waitFor(10);
            putTexttoExcel(jobList, fileName,"Name", "Page1");
            putTexttoExcel(jobLinks, fileName,"List", "Page1");

        }
    }

}
