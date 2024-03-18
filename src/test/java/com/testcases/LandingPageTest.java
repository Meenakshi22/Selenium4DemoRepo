package com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LandingPage;
import com.pages.LoginPage;

public class LandingPageTest extends TestBase{
	
	LandingPage obj;
	LoginPage obj2;
	

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		obj = new LandingPage();
	}

	@Test
	public void verifyLandingPageLoginButton() {
		obj2 = obj.clickLogInButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
