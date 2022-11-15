package com.Flipkart.Stepdefenition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TvPurchese {
	
	String input;
	@When("user search Tv")
	public void user_search_Tv() {
		input = "Samsung Tv";
		MobileSteps.driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}


	@When("user choose the Tv")
	public void user_choose_the_Tv() {
		String parent = MobileSteps.driver.getWindowHandle();
		
		Set<String> child = MobileSteps.driver.getWindowHandles();
		for (String x:child) {
			if(!parent.equals(child)) {
				MobileSteps.driver.switchTo().window(x);
				System.out.println("Window Switched");
			}
		}
	    
	}
	@When("user search Tv by using oneD List")
	public void user_search_Tv_by_using_oneD_List(DataTable dataTable) {
		List<String> Tv = dataTable.asList();
		input = Tv.get(2);
		MobileSteps.driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}
	
	@When("user search Tv by using oneD map")
	public void user_search_Tv_by_using_oneD_map(DataTable dataTable) {
		Map<String, String> phone = dataTable.asMap(String.class, String.class);
		input = phone.get("phone1");
		MobileSteps.driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}
	
	@When("user search Tv {string}")
	public void user_search_Tv(String string) {
		input = string;
		MobileSteps.driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement tvClick = MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = tvClick.getText();
	    tvClick.click();
	}
}
