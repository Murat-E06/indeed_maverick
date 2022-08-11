package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.JobDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class JobDetail_StepDefinitions {

    JobDetailPage jobDetailPage = new JobDetailPage();

    @Then("user gets the detail of the first job")
    public void user_gets_the_detail_of_the_first_job() {

        jobDetailPage.closeEmailWindow();
/*
        BrowserUtils.waitForVisibility(jobDetailPage.jobDetailName,10);

        String jobDetailNameText = jobDetailPage.getTextOfElement(jobDetailPage.jobDetailName);
        System.out.println("jobDetailNameText = " + jobDetailNameText);

 */
        BrowserUtils.waitFor(10);

        jobDetailPage.firstPageJobBoxesAreas.get(2).click();
       // BrowserUtils.webElementExists(jobDetailPage.jobDescriptionTextList);
       // String text = jobDetailPage.getTextOfElements(jobDetailPage.jobDescriptionTextList);
      //  System.out.println("text = " + text);

        if(BrowserUtils.webElementExists(jobDetailPage.jobDetailSalary)){
            String salary = jobDetailPage.getTextOfElement(jobDetailPage.jobDetailSalary);
            System.out.println("salary = " + salary);
        }else{
            System.out.println("No salary info");
        }





    }

}
