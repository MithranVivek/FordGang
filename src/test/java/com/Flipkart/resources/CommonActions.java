package com.Flipkart.resources;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Flipkart.Stepdefenition.MobileSteps;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonActions {
	public static WebDriver driver;
	
	public void launch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}
	public void insertText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void insertTextEnter(WebElement element, String value) {
		element.sendKeys(value, Keys.ENTER);
	}
	
	public void insertTextTab(WebElement element, String value) {
		element.sendKeys(value, Keys.TAB);
	}
	
	public void insertText(String value) {
		Actions a = new Actions(driver);
		a.sendKeys(value).build().perform();
	}
	
	public String getValue(WebElement element) {
		String text = element.getText();
		return text;
	}
	public void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x:child) {
			if(!parent.equals(child)) {
				driver.switchTo().window(x);
				System.out.println("Window Switched");
			}
		}
	}
	
	 public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}
	 
	 public void implicity(int timeout) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	 }

}
