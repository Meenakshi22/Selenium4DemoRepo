package testsamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotationsTest {
	@BeforeSuite
	public void display() {
		System.out.println("This is before suite");
	}
	@BeforeTest
	public void display2() {
		System.out.println("This is before test");
	}
	@BeforeClass
	public void display3() {
		System.out.println("This is before class");
	}
	@BeforeMethod
	public void display4() {
		System.out.println("This is before method");
	}
	@Test
	public void display5() {
		System.out.println("This is test method");
	}
	@AfterMethod
	public void display6() {
		System.out.println("This is after method");
	}
	@AfterClass
	public void display7() {
		System.out.println("This is after class");
	}
	@AfterTest
	public void display8() {
		System.out.println("This is after test");
	}
	@AfterSuite
	public void display9() {
		System.out.println("This is after suite");
	}
	

}
