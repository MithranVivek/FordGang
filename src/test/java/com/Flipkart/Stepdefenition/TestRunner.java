package com.Flipkart.Stepdefenition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources//Features", 
//				 glue = "com.Facebook.login",
				 plugin = "html:target",
				 monochrome = true,
				 dryRun = true
				 )
public class TestRunner {

}
