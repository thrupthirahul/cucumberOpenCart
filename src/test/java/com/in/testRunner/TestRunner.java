package com.in.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "resources/features",
        glue = {
                "com.in.hooks",
                "com.in.stepDefinitions"
        },
        tags = "@smoke",
        monochrome = false,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber_report.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
