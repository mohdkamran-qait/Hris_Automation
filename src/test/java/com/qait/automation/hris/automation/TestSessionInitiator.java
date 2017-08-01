package com.qait.automation.hris.automation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qait.automation.hris.keywords.GetRecordsActions;
import com.qait.automation.hris.keywords.LoginPageActions;
import com.qait.automation.hris.utils.LocatorReader;

public class TestSessionInitiator {

	WebDrivers wd = new WebDrivers();
	public WebDriver myDriver;
	public LoginPageActions loginPage;
	public GetRecordsActions getRec;
	LocatorReader lr;
	String username;
	String password;

	public TestSessionInitiator() throws IOException {
		// TODO Auto-generated constructor stub

		try {
			wd.load_config_properties_file();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDriver = wd.getBrowser();
		myDriver.manage().window().maximize();
		try {
			initActionClasses();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initActionClasses() throws IOException, InterruptedException {
		loginPage = new LoginPageActions(myDriver);
		getRec = new GetRecordsActions(myDriver);

	}

}
