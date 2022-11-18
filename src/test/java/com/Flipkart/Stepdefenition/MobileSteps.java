package com.Flipkart.Stepdefenition;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Flipkart.objectrpository.MobilePage;
import com.Flipkart.resources.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSteps extends CommonActions{
	
	CommonActions c = new CommonActions();
	MobilePage m = new MobilePage();
	
	@Given("user login to flipkart")
	public void user_login_to_flipkart() {
		try {
			m.getLogin().click();
			} catch (Exception e) {
				System.out.println("Login not required");
			}
	}
	String input;
	@When("user search mobile")
	public void user_search_mobile() {
		input = "Samsung mobile";
		WebElement element = m.getSearch(); 
//				driver.findElement(By.name("q"));
		c.insertTextEnter(element, input);
		WebElement mobileClick = m.getPickProduct();
	    c.getValue(mobileClick);
	    mobileClick.click();
	}


	@When("user choose the mobile")
	public void user_choose_the_mobile() {
		c.windowHandle();
	}

	@When("user doing payment by using UPI")
	public void user_doing_payment_by_using_UPI() throws Throwable {
		WebElement buy = m.getScrollTo();
		c.implicity(10);
		c.scrollDown(buy);
		WebElement buynow = m.getBuy();
		String name = buynow.getText();
		Assert.assertEquals("BUY NOW", name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		buynow.click();
	}

	@Then("user receives confirmation message")
	public void user_receives_confirmation_message() throws Throwable {
//		Thread.sleep(5000);
//	    driver.quit();
	}
	
	@When("user search mobile by using oneD List")
	public void user_search_mobile_by_using_oneD_List(DataTable dataTable) {
		List<String> mobile = dataTable.asList();
		input = mobile.get(2);
		WebElement element = driver.findElement(By.name("q"));
		c.insertTextEnter(element, input);
		WebElement mobileClick = m.getPickProduct();
		c.getValue(mobileClick);
	    mobileClick.click();
	}
	
	@When("user search mobile by using oneD map")
	public void user_search_mobile_by_using_oneD_map(DataTable dataTable) {
		Map<String, String> phone = dataTable.asMap(String.class, String.class);
		input = phone.get("phone1");
		WebElement element = m.getSearch();
		c.insertTextEnter(element, input);
		WebElement mobileClick = m.getPickProduct();
		c.getValue(mobileClick);
	    mobileClick.click();
	}
	
	@When("user search mobile {string}")
	public void user_search_mobile(String string) {
		input = string;
		WebElement element = m.getSearch();
		c.insertTextEnter(element, string);
		WebElement mobileClick = m.getPickProduct();
	    c.getValue(mobileClick);
	    mobileClick.click();
	}

}
