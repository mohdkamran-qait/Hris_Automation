package com.qait.automation.hris.keywords;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qait.automation.hris.automation.WebDrivers;
import com.qait.automation.hris.test.HRISAutomation;
import com.qait.automation.hris.utils.LocatorReader;
import com.qait.automation.hris.utils.SpecFileReader;

public class LoginPageActions {
	SpecFileReader sr = new SpecFileReader();
	WebDriver driver;
	String username;
	String password;

	LocatorReader lr;

	public LoginPageActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.lr = new LocatorReader("src/test/resources/locators/locators.spec");
	}

	public void verifyLogin() throws IOException, InterruptedException {

		username = sr.loadusername();
		password = sr.loadpassword();
		driver.get("https://hris.qainfotech.com/login.php");
		Thread.sleep(2000);

		driver.findElement(lr.getlocator("tab_loginPage")).click();
		driver.findElement(lr.getlocator("input_username")).sendKeys(username);
		driver.findElement(lr.getlocator("input_password")).sendKeys(password);
		driver.findElement(lr.getlocator("loginPage_submitButton")).click();

	}

}
