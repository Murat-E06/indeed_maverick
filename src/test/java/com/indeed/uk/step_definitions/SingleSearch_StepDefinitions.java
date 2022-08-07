package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.BasePage;
import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.ConfigurationReader;
import com.indeed.uk.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.swing.text.Utilities;
import java.util.Arrays;

public class SingleSearch_StepDefinitions {

    BasePage basePage = new BasePage();

    public void closeWindows(){

        if(BrowserUtils.webElementExists(basePage.acceptAllCookiesButton)){
            basePage.acceptAllCookiesButton.click();
        }

        if(BrowserUtils.webElementExists(basePage.ukraine)){
            basePage.ukraine.click();
        }
        if(BrowserUtils.webElementExists(basePage.signInWithGoogleCloseButton)){
            basePage.signInWithGoogleCloseButton.click();
        }




    }

    @Given("user opens indeed home page")
    public void user_opens_indeed_home_page() {
        Driver.getDriver().get("https://uk.indeed.com/");
        BrowserUtils.waitFor(3);


    }

    @When("user inputs {string} to What and {string} to Where boxes")
    public void userInputsToWhatAndToWhereBoxes(String job, String city) {
        basePage.whatBox.sendKeys(job);
        BrowserUtils.waitFor(3);
        // String expectedTitle=job+" job in "+city;

        basePage.whereBox.sendKeys(city);
        BrowserUtils.waitFor(3);
    }

    @And("user clicks Find jobs button")
    public void userClicksFindJobsButton() {
        basePage.findJobsButton.click();
        BrowserUtils.waitFor(3);

    }


    @Then("user sees {string} and {string} results successfully")
    public void userSeesAndResultsSuccessfully(String job, String city) {

        String actualTitle = Driver.getDriver().getTitle().toLowerCase();
        System.out.println("actualTitle = " + actualTitle);
        BrowserUtils.waitFor(3);

        Assert.assertTrue(actualTitle.contains(city.toLowerCase()));
        Assert.assertTrue(actualTitle.contains(job.toLowerCase()));


    }

    @Then("user sees number of job results successfully")
    public void user_sees_number_of_job_results_successfully() {

        String numberOfJobText = basePage.numberOfJobs.getText();
        //Page 1 of 12 jobs
        String [] words = numberOfJobText.split(" ");

        System.out.println("Number of jobs = " + words[3]);//[Page, 1, of, 46, jobs]

        Assert.assertTrue(basePage.numberOfJobs.isDisplayed());
        Assert.assertFalse(words[3].startsWith("0"));

    }

    @When("user selects {int} miles from dropdown")
    public void user_selects_miles_from_dropdown(Integer miles) {
        BrowserUtils.waitFor(3);
        basePage.radiusButton.click();
        //BrowserUtils.waitForClickablility(basePage.radiusList.get(6),3);
        //basePage.radiusList.get(6).click();

        System.out.println("miles = " + miles);
        BrowserUtils.waitForClickablility(basePage.getRadiusFilter(miles),3);
        basePage.getRadiusFilter(miles).click();

    }

    @Then("user clicks all unnecessary visible windows")
    public void userClicksAllUnnecessaryVisibleWindows() {
        closeWindows();

    }
}
/*
 @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select=new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }
    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {
        //accepting int argument and sending it using sendKeys() method
        //since sendKeys() method only accepts String, we need to either concat with ""
        //or send String.valueOf(int);
        //orderPage.inputQuantity.sendKeys(String.valueOf(quantity));

        //clear() method will delete whatever is in the input box
        //orderPage.inputQuantity.clear();

        //imitating pressing back_space button from keyboard to delete existing input
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        orderPage.inputQuantity.sendKeys(quantity+"");//changing int to String with "" like java
    }
 */