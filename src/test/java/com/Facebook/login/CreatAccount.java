package com.Facebook.login;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatAccount {
	
	static WebDriver driver;
	@Given("user goto facebook page")
	public void user_goto_facebook_page() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.facebook.com/");
	    driver.manage().window().maximize();
	   
	}
	@Given("clear cach and cookies")
	public void clear_cach_and_cookies() {
		 driver.manage().deleteAllCookies();
	}
	
	@When("user select create new account")
	public void user_select_create_new_account() {
	   driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
	}
	
	@When("fill the signup page")
	public void fill_the_signup_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("firstname")).sendKeys("vivekbabu",Keys.TAB);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("lastname")).sendKeys("p",Keys.TAB);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email__")).sendKeys("vivekbabu",Keys.TAB);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vivekbabu",Keys.TAB);
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.findElement(By.name("reg_passwd__")).sendKeys("Creat@123",Keys.TAB);
	    
	}

	@When("fill the date of birth")
	public void fill_the_date_of_birth() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    Select day = new Select(driver.findElement(By.id("day")));
	    day.selectByValue("9");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    Select month = new Select(driver.findElement(By.id("month")));
	    month.selectByVisibleText("Jul");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    Select year = new Select(driver.findElement(By.id("year")));
	    year.selectByValue("1991");
	   
	}

	@When("select gender")
	public void select_gender() {
		String gender = "Male";
	    if(gender.equals("Female")) {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
	    }else if (gender.equals("Male")) {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
	    }else {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[3]")).click();
	    	Select custom = new Select(driver.findElement(By.name("preferred_pronoun")));
	    	custom.selectByIndex(3);
	    }
	}

	String input;
	@When("fill the signup page by using oneD map")
	public void fill_the_signup_page_by_using_oneD_map(DataTable dataTable) {
		Map<String, String> inputData = dataTable.asMap(String.class, String.class);
		input = inputData.get("firstname");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("firstname")).sendKeys(input,Keys.TAB);
		input = inputData.get("surename");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("lastname")).sendKeys(input,Keys.TAB);
		input = inputData.get("email");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email__")).sendKeys(input,Keys.TAB);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(input,Keys.TAB);
	    input = inputData.get("New Password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.findElement(By.name("reg_passwd__")).sendKeys(input,Keys.TAB);
		
	}

	@When("fill the date of birth by using oneD map")
	public void fill_the_date_of_birth_by_using_oneD_map(DataTable dataTable) {
		Map<String,String> dob = dataTable.asMap(String.class, String.class);
		input = dob.get("day");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select day = new Select(driver.findElement(By.id("day")));
		    day.selectByValue(input);
		 input = dob.get("month");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select month = new Select(driver.findElement(By.id("month")));
		    month.selectByVisibleText(input);
	     input = dob.get("year");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select year = new Select(driver.findElement(By.id("year")));
		    year.selectByValue(input);
	}

	@SuppressWarnings("unlikely-arg-type")
	@When("select gender by using oneD list")
	public void select_gender_by_using_oneD_list(DataTable dataTable) {
		List<String> gender = dataTable.asList();
				input = gender.get(1);
		    if(gender.equals("Female")) {
		    	driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		    }else if (gender.equals("Male")) {
		    	driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
		    }else {
		    	driver.findElement(By.xpath("(//input[@name='sex'])[3]")).click();
		    	Select custom = new Select(driver.findElement(By.name("preferred_pronoun")));
		    	custom.selectByIndex(3);
		    }
	}
	@When("take screen shot")
	public void take_screen_shot() throws IOException {
	   TakesScreenshot tk = (TakesScreenshot)driver;
	   File scr = tk.getScreenshotAs(OutputType.FILE);
	   File location = new File("C:\\Users\\Windows\\eclipse-vivek\\WorkOut\\target\\signup.png");
	   FileUtils.copyFile(scr, location);
	}
	@When("fill the signup page {string},{string},{string},{string},{string}")
	public void fill_the_signup_page(String string, String string2, String string3, String string4,String string5) {
		String firstname = string;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("firstname")).sendKeys(firstname,Keys.TAB);
		String surename = string2;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("lastname")).sendKeys(surename,Keys.TAB);
		String email = string3;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email__")).sendKeys(email,Keys.TAB);
	    String Reemail = string4;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(Reemail,Keys.TAB);
	    String NewPassword = string5;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.findElement(By.name("reg_passwd__")).sendKeys(NewPassword,Keys.TAB);
	}

	@When("fill the date of birth {string}, {string}, {string}")
	public void fill_the_date_of_birth(String string, String string2, String string3) {
		input = string;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select day = new Select(driver.findElement(By.id("day")));
		    day.selectByValue(input);
		 input = string2;
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select month = new Select(driver.findElement(By.id("month")));
		    month.selectByVisibleText(input);
	     input = string3;
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    Select year = new Select(driver.findElement(By.id("year")));
		    year.selectByValue(input);
   
	}

	@When("select gender {string}")
	public void select_gender(String string) {
		input = string;
	    if(input.equals("Female")) {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
	    }else if (input.equals("Male")) {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
	    }else {
	    	driver.findElement(By.xpath("(//input[@name='sex'])[3]")).click();
	    	Select custom = new Select(driver.findElement(By.name("preferred_pronoun")));
	    	custom.selectByIndex(3);
	    }
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(7000);
		driver.quit();
	    
	}

}
