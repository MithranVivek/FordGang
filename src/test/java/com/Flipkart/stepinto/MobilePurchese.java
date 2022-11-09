package com.Flipkart.stepinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class MobilePurchese {
	static WebDriver driver;
//	static WebDriverWait wd = new WebDriverWait(driver, Duration.ofMinutes(20));
	@BeforeClass
	public static void beforeLaunch() {
		System.out.println("Before Launch");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com/");
		
	}
	@AfterClass
	public static void afterLaunch() {
		System.out.println("After Launch");
		driver.quit();
	}
	@Before
	public void beforeTest() {
//		System.out.println("Before test");

	}
	@After
	public void afterTest() {
//		System.out.println("Before test");

	}
	
	@Test
	public void test1() {
		System.out.println("login");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	@Test
	public void test2() throws Throwable {
		System.out.println("search");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung Mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Test
	public void test3() throws IOException {
		System.out.println("Moblie choose");
		File f = new File("C:\\Users\\Windows\\eclipse-vivek\\Junit\\target\\Flipkart.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Flipkart Mobile");
		
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofMinutes(20));
//		wd.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_4rR01T']")));
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
	
	@Test
	public void test4() throws IOException {
		System.out.println("Window");
		FileWriter fw = new FileWriter("C:\\Users\\Windows\\eclipse-vivek\\Junit\\target\\Flipkart1.txt");
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
	@Test
	public void test5() throws IOException {
		System.out.println("Validation");
		
		File f = new File("C:\\Users\\Windows\\eclipse-vivek\\Junit\\target\\Flipkart.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		Workbook w1 = new XSSFWorkbook(f1);
		Sheet s1 = w1.getSheet("Flipkart Mobile");
		Row r = s1.getRow(2);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		System.out.println("From Excel Value : ");
		System.out.println(value);
		
		FileReader fr = new FileReader("C:\\Users\\Windows\\eclipse-vivek\\Junit\\target\\Flipkart1.txt");
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
