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
        features = {"src/test/resources/features"},
        glue = {"com/indeed/uk/step_definitions"},
        dryRun = false,
        tags = "@remote"
)

public class CukesRunner {
}
