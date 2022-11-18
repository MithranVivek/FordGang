package com.Flipkart.Stepdefenition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Flipkart.objectrpository.TvPage;
import com.Flipkart.resources.CommonActions;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TvPurchese extends CommonActions{
	
	CommonActions c = new CommonActions();
	TvPage t = new TvPage();
	
	String input;
	@When("user search Tv")
	public void user_search_Tv() {
		input = "Samsung Tv";
		WebElement element = t.getSearch();
		c.insertTextEnter(element, input);
		WebElement mobileClick = t.getPickProduct();
		c.getValue(mobileClick);
	    mobileClick.click();
	}


	@When("user choose the Tv")
	public void user_choose_the_Tv() {
		c.windowHandle();
	    
	}
	@When("user search Tv by using oneD List")
	public void user_search_Tv_by_using_oneD_List(DataTable dataTable) {
		List<String> Tv = dataTable.asList();
		input = Tv.get(2);
		WebElement element = t.getSearch();
		c.insertTextEnter(element, input);
		WebElement mobileClick = t.getPickProduct();
	    c.getValue(mobileClick);
	    mobileClick.click();
	}
	
	@When("user search Tv by using oneD map")
	public void user_search_Tv_by_using_oneD_map(DataTable dataTable) {
		Map<String, String> phone = dataTable.asMap(String.class, String.class);
		input = phone.get("phone1");
		WebElement element = driver.findElement(By.name("q"));
		c.insertTextEnter(element, input);
		WebElement mobileClick = t.getPickProduct();
	    c.getValue(mobileClick);
	    mobileClick.click();
	}
	
	@When("user search Tv {string}")
	public void user_search_Tv(String string) {
		input = string;
		WebElement element = t.getSearch();
		c.getValue(element);
		WebElement tvClick = t.getPickProduct();
		c.getValue(tvClick);
	    tvClick.click();
	}
}
