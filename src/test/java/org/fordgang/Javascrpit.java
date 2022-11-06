package org.fordgang;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Javascrpit {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows 11\\workspace\\Selli\\lib2\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		JavascriptExecutor j = (JavascriptExecutor)driver;
		
        WebElement email =driver.findElement(By.xpath("//input[@type='text']"));
	    j.executeScript("arguments[0].setAttribute('value','9042782824')",email);
	    
	    WebElement pass =driver.findElement(By.xpath("//input[@type='password']"));
	    pass.sendKeys("Janesh@13");
	    
        WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
        j.executeScript("arguments[0].click()",login);
	    
	    Thread.sleep(9000);
	    
	    
	    WebElement scroll =driver.findElement(By.xpath("(//li[contains(text(),'English')])"));
	    j.executeScript("arguments[0].scrollIntoView(false);", scroll);
	    
        Actions ac = new Actions (driver);
	    WebElement click =driver.findElement(By.xpath("(//li[contains(text(),'English')])"));
        ac.doubleClick(click).build().perform();
	    
        
	    Thread.sleep(9000);
	    j.executeScript("window.scrollBy(0,-50)", "");
	
}

}
