package org.TestWork;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class JavascriptAll  {
	public static void main(String[] args) throws InterruptedException {
     
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.flipkart.com/");
	    driver.manage().window().maximize();
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(100));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
	
        
        JavascriptExecutor js= (JavascriptExecutor)driver;

        WebElement id=driver.findElement(By.xpath("(//input[@type='text'])[2]")); //sendkey
        js.executeScript("arguments[0].setAttribute('value','saravann')",id);
        
        WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));//sendkey get text
        js.executeScript("arguments[0].setAttribute('value','sarwan2456')",pass);
        Object o=js.executeScript("return arguments[0].getAttribute('value')",pass);
        System.out.println(o);
     
        WebElement login=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));// click
        js.executeScript("arguments[0].click()", login);
        
        WebElement close=driver.findElement(By.xpath("//button[text()='✕']"));
        js.executeScript("arguments[0].click()", close);
        
        Thread.sleep(5000);

        WebElement down=driver.findElement(By.xpath("(//a[@class='_1arVWX'])[1]")); //down
        js.executeScript("arguments[0].scrollIntoView(true)",down);
        Thread.sleep(5000);
        
//        js.executeScript("window.scrollBy(0,350)", "");
//        Thread.sleep(5000);
//        js.executeScript("window.scrollBy(0,-350)", "");
//        Thread.sleep(5000);

//        WebElement up=driver.findElement(By.xpath("//a[@class='_1_3w1N']"));  //up
//        js.executeScript("arguments[0].scrollIntoView(false)", up);

        

		
		
		
		
		
		
	}
}
