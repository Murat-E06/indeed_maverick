package com.indeed.uk.step_definitions;

import com.indeed.uk.utilities.Driver;
import io.cucumber.java.en.Given;

public class SingleSearch_StepDefinitions {

    @Given("user opens indeed home page")
    public void user_opens_indeed_home_page() {
        Driver.getDriver().get("https://uk.indeed.com/");
    }
}
