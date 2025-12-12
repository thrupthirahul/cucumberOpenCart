package com.in.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "resources/features",
		glue = {"com.in.hooks", "com.in.stepDefinitions"},
		tags="@dev",
		monochrome = true, //ignore wried character in the feature file
		dryRun= false, // run feature file only
		stepNotifications = true,
		plugin = {"pretty",
				"html:target/cucumber_report.html"
		}
	)
public class TestRunner { 

}
