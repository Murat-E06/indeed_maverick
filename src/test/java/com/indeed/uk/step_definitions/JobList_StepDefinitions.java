package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.JobDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobList_StepDefinitions {

    JobDetailPage jobDetailPage = new JobDetailPage();


    @Then("user gets the list of jobs")
    public void user_gets_the_list_of_jobs() {
       jobDetailPage.closeEmailWindow();

        BrowserUtils.waitFor(10);
        String result = jobDetailPage.getTextOfElements(jobDetailPage.jobList);
        System.out.println("result = \n" + result);

    }

    @Then("user clicks pages number buttons and get all list of jobs")
    public void userClicksPagesNumberButtonsAndGetAllListOfJobs() {
       jobDetailPage.closeEmailWindow();

        String result= jobDetailPage.getTextOfAllPagesElements(jobDetailPage.pageNumberList);
        //String result= jobDetailPage.getTextOfAllPagesWithWhileLoop(jobDetailPage.pageNumberList);
        System.out.println("result all pages = " + result);


    }


    @Then("user gets the list of the jobs in Map format")
    public void userGetsTheListOfTheJobsInMapFormat() {

        List<Map> jobList = new ArrayList<>();
        for (WebElement each : jobDetailPage.jobList) {
            Map<String, String> job=new HashMap<>();
            job.put("jobName", each.getText() );
            jobList.add(job);
        }
        System.out.println(jobList);

    }
}



