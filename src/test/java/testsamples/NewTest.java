package testsamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	static WebDriver driver;

	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/index.html");
		driver.manage().window().maximize();
	}
	@Parameters({"first-name","last-name","email","message"})
	@Test
	public void fillForm(String firstname,String lastname, String email,String message ) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(@href,'contact')]")).click();
		System.out.println(driver.getCurrentUrl());
		String parent_id=driver.getWindowHandle();
		Set<String> child_ids = driver.getWindowHandles();
		 for (String a : child_ids) { 
	            if (parent_id.equals(a)) { 
	            } 
	            else { // to change focus on new window 
	                driver.switchTo().window(a); 
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[contains(@name,'first')]")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[contains(@name,'last')]")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys(email);
		driver.findElement(By.xpath("//textarea[contains(@name,'message')]")).sendKeys(message);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	            
	            }
		 }
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
