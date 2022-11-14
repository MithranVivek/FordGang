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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSteps {
	
	static WebDriver driver;
	
	@Given("user login to flipkart")
	public void user_login_to_flipkart() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
//		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(user);
//		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		} catch (Exception e) {
			System.out.println("Login not required");
		}
	}
	String input;
	@When("user search mobile")
	public void user_search_mobile() {
		input = "Samsung mobile";
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}


	@When("user choose the mobile")
	public void user_choose_the_mobile() {
		String parent = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();
		for (String x:child) {
			if(!parent.equals(child)) {
				driver.switchTo().window(x);
				System.out.println("Window Switched");
			}
		}
	    
	}

	@When("user doing payment by using UPI")
	public void user_doing_payment_by_using_UPI() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement buy = driver.findElement(By.xpath("//div[text()='You might be interested in']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView(false)", buy);
		WebElement buynow = driver.findElement(By.xpath("//button[text()='BUY NOW']"));
		String name = buynow.getText();
		Assert.assertEquals("BUY NOW", name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		buynow.click();
	}

	@Then("user receives confirmation message")
	public void user_receives_confirmation_message() throws Throwable {
		Thread.sleep(5000);
	    driver.quit();
	}
	
	@When("user search mobile by using oneD List")
	public void user_search_mobile_by_using_oneD_List(DataTable dataTable) {
		List<String> mobile = dataTable.asList();
		input = mobile.get(2);
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}
	
	@When("user search mobile by using oneD map")
	public void user_search_mobile_by_using_oneD_map(DataTable dataTable) {
		Map<String, String> phone = dataTable.asMap(String.class, String.class);
		input = phone.get("phone1");
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}
	
	@When("user search mobile {string}")
	public void user_search_mobile(String string) {
		input = string;
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
		WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	    String mName = mobileClick.getText();
	    mobileClick.click();
	}

}
