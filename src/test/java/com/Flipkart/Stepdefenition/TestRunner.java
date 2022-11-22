package com.Flipkart.Stepdefenition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources//Features", 
				 glue = "com.Flipkart.Stepdefenition",
				 plugin = {"html:target","json:target/reports.json"},
				 monochrome = true,
				 dryRun = false,
				 tags = {"@mobile","@tv","@sm1","@st1"}
				 )
public class TestRunner {

}
