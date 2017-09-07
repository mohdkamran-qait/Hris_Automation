package com.qait.automation.hris.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import com.qait.automation.hris.automation.TestSessionInitiator;
import com.qait.automation.hris.utils.LocatorReader;



public class HRISAutomation {
	public LocatorReader lr;
	public TestSessionInitiator ti;
	public String username;
	public String password;

	@BeforeClass
	public void initSession() throws IOException {
		ti = new TestSessionInitiator();
	}

	@Test
	public void T1_verifyLoginFunctionality() throws IOException, InterruptedException {
		System.out.println("Executing test to check user is able to login");
		ti.loginPage.verifyLogin();
	}

	@Test
	public void T2_verifyRecordFetching() throws IOException {
		System.out.println("Executing test to check user is able to get data");
		ti.getRec.getRecords();
	}
	
	@AfterClass
	public void closeSession() throws IOException {
		ti.closeSession();
	}

}
