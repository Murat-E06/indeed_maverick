package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.RemoteDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoteJobs_StepDefinitions {

    RemoteDetailPage remoteDetailPage= new RemoteDetailPage();

    @When("user inputs {string} to What box")
    public void user_inputs_to_what_box(String job) {
        BrowserUtils.waitForVisibility(remoteDetailPage.whatBox,5);
        remoteDetailPage.whatBox.clear();
        remoteDetailPage.whatBox.sendKeys(job);
        BrowserUtils.waitFor(3);

    }
    @When("user selects remote jobs")
    public void user_selects_remote_jobs() {

        BrowserUtils.waitFor(3);
        remoteDetailPage.remoteButton.click();


        BrowserUtils.waitForClickablility(remoteDetailPage.remoteSelection.get(0),10);
        remoteDetailPage.getRemoteOption("Remote").click();



    }

    @Then("user puts the list of jobs to excel")
    public void user_puts_the_list_of_jobs_to_excel() {

        remoteDetailPage.closeEmailWindow();

        BrowserUtils.waitFor(10);
        remoteDetailPage.putTextOfAllPagestoExcel(remoteDetailPage.jobList);
        BrowserUtils.waitFor(10);
        remoteDetailPage.printExcel(3);

    }
}
