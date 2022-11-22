package linkstatus;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
		public static void main(String[] args) throws Throwable {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows\\eclipse-vivek\\SeleniumTest\\Drivers\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			String homepage = "https://www.facebook.com/";
			driver.get(homepage);
			Thread.sleep(3000);
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			
			Iterator<WebElement> iterat = links.iterator(); 
			
			while (iterat.hasNext()) {
				
			String url = iterat.next().getAttribute("href");
			int i = 1;
			int j = 1;
			int k = 1;
			int l = 1;
			if (url== null || url.isEmpty()) 
			{
				
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
				
			}
			if (!url.startsWith(homepage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
							
				URL link = new URL(url);
				HttpURLConnection connection = (HttpURLConnection)link.openConnection();
				
				Thread.sleep(2000);
				connection.connect();
				int responseCode = connection.getResponseCode();
				
				if (responseCode>=400) {
					System.out.println(url + " - is Broken Link");
				}
				else {
					System.out.println(url + " - is Valid Link");
				}	
			}
			driver.quit();
		}
		
}
