package com.indeed.uk.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = {"src/test/resources/regression_features"},
        glue = {"com/indeed/uk/step_definitions"},
        dryRun = false,
        tags = ""
)

public class RegressionRunner {
}
