package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.LocalDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class LocalJobs_StepDefinitions {

    LocalDetailPage localDetailPage= new LocalDetailPage();

    @Then("user puts the list of local jobs to excel")
    public void user_puts_the_list_of_local_jobs_to_excel() {
        localDetailPage.closeEmailWindow();

        BrowserUtils.waitFor(10);
        localDetailPage.putTextOfAllPagestoExcel(localDetailPage.jobList, "localJobs.xlsx");
        BrowserUtils.waitFor(10);
        localDetailPage.printExcel("localJobs.xlsx",1);
    }

}
