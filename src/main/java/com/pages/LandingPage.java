package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LandingPage extends TestBase {
	

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement login_button;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogInButton() {
		login_button.click();
		return new LoginPage();
	}
}
