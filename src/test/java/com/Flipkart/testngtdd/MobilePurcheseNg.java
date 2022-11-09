package com.Flipkart.testngtdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurcheseNg {
	static WebDriver driver;
	
	@DataProvider(name = "login")
	public Object[][] getloginData(){
		return new Object[][] {{"vivekbabu","yutikshaa"}};
		
	}
	
	@DataProvider(name = "search")
	public Object[][] getMobileData(){
		return new Object[][] {{"Samsung Mobile"}};
		
	}
	
	@BeforeClass(groups = "default")
	public static void beforeLaunch() {
		System.out.println("Before Launch");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com/");
		
	}
	
	@AfterClass(groups = "default")
	public static void afterLaunch() {
		System.out.println("After Launch");
		driver.quit();
	}
	
	@BeforeMethod(groups = "default")
	public void beforeTest() {
		System.out.println("Before Method");

	}
	
	@AfterMethod(groups = "default")
	public void afterTest() {
		System.out.println("After Method");

	}
	
	@Parameters({"username","password"})
	@Test(priority = 1, enabled = true, groups = "smoke")
	public void login(@Optional("vivek") String user, @Optional("babu") String pass) {
		System.out.println("login");
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
	
	@Test(priority = 2,dataProvider = "search", enabled = true, groups = "smoke")
	public void search(String input) throws Throwable {
		System.out.println("search");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(input);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@Test(priority = 3, enabled = true, groups = "smoke")
	public void mobileChoose() throws IOException {
		System.out.println("Moblie choose");
		
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofMinutes(20));
//		wd.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_4rR01T']")));
		
		File f = new File("C:\\Users\\Windows\\eclipse-vivek\\WorkOut\\target\\Flipkart1.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Mobile Ng");
		
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_4rR01T']")));
		List<WebElement> redmi=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(int i=0;i<redmi.size();i++) {
			WebElement name=redmi.get(i);
			String text=name.getText();
//			System.out.println(text);
			 Row r = s.createRow(i);
		     Cell c = r.createCell(0);
	       	 c.setCellValue(text);
		}
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		fo.close();
		
	}
	
	@Test(priority = 4, enabled = true, groups = "sanity", invocationCount = 3)
	public void window() throws IOException {
		System.out.println("Window");
		FileWriter fw = new FileWriter("C:\\Users\\Windows\\eclipse-vivek\\WorkOut\\target\\Flipkart1.txt");
		String parant = driver.getWindowHandle();			
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]")).click();
		
		 Set<String> child = driver.getWindowHandles();
	        List<String> child1=new ArrayList<String>(child);
	        
	        driver.switchTo().window(child1.get(1));
		String text1 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
//		System.out.println("In Website Selected 3rd Mobile Link : ");
//		System.out.println(text1);
		
		fw.write(text1);
		fw.close();
	}
	
	@Test(priority = 5, enabled = false, groups = "sanity")
	public void validation() throws IOException {
		System.out.println("Validation");
		
		File f = new File("C:\\Users\\Windows\\eclipse-vivek\\WorkOut\\target\\Flipkart1.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		Workbook w1 = new XSSFWorkbook(f1);
		Sheet s1 = w1.getSheet("Mobile Ng");
		Row r = s1.getRow(2);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		System.out.println("From Excel Value : ");
		System.out.println(value);
		
		FileReader fr = new FileReader("C:\\Users\\Windows\\eclipse-vivek\\WorkOut\\target\\Flipkart1.txt");
		BufferedReader br = new BufferedReader(fr);
		String text;
		while ((text = br.readLine()) != null) {
			System.out.println("Notepad Stored Data : ");
			System.out.println(text);
			Assert.assertEquals(value,text);
		}
		
		br.close();
				
		
	}

}
