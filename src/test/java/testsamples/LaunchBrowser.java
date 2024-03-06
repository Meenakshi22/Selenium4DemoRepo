package testsamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenersDemo.class)
public class LaunchBrowser {
	static WebDriver driver;

	@BeforeMethod
	public void initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void launchChromeBrowser() throws InterruptedException {

		driver.get("https://ultimateqa.com/automation");
		driver.findElement(By.partialLinkText("Interactions with simple elements")).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Dropdown')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Select dropdown = new Select(driver.findElement(By.xpath("//select")));
		dropdown.selectByIndex(1);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(element);
		Thread.sleep(1000);
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void sampleAssert()
	{
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
}
