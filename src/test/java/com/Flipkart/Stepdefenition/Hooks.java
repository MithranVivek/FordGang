package com.Flipkart.Stepdefenition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Flipkart.resources.CommonActions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonActions{
	
	CommonActions c = new CommonActions();
	@Before
	public void beforeScenario() throws Throwable {
		try {
		c.launch("https://flipkart.com/");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@After
	public void afterMethod(Scenario scenario) {
		if(scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}else{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

}
