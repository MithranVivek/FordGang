package com.Flipkart.Stepdefenition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Flipkart.resources.CommonActions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends CommonActions{
	
	CommonActions c = new CommonActions();
	@Before
	public void beforeScenario() {
		
		c.launch("https://flipkart.com/ ");
		
	}
	@After
	public void afterMethod() {
		driver.quit();
	}

}
