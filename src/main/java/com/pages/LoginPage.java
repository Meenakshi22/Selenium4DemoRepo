package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {
	WebDriver driver;
	LandingPage obj = new LandingPage();

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "//div[contains(text(),'Login')]")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void getPageTitle() {
		LoginPage page2 = obj.clickLogInButton();
		System.out.println(driver.getTitle());
	}

	public void clickLoginButton() {
		email.sendKeys("meenakshirajasekar07@gmail.com");
		password.sendKeys("Rvkm4@fam");
		login.click();
	}
}
