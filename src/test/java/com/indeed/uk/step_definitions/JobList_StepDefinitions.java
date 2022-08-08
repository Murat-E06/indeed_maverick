package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.JobDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class JobList_StepDefinitions {

    JobDetailPage jobDetailPage = new JobDetailPage();


    @Then("user gets the list of jobs")
    public void user_gets_the_list_of_jobs() {

        jobDetailPage.closeEmailWindow();

        BrowserUtils.waitFor(10);
        String result = jobDetailPage.getTextOfElements(jobDetailPage.jobList);
        System.out.println("result = " + result);

    }

    @Then("user clicks pages number buttons and get all list of jobs")
    public void userClicksPagesNumberButtonsAndGetAllListOfJobs() {
        jobDetailPage.closeEmailWindow();

      String result= jobDetailPage.getTextOfAllPagesElements(jobDetailPage.pageNumberList);
       System.out.println("result all pages = " + result);


    }


}
