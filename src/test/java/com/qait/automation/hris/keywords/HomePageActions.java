package com.qait.automation.hris.keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import com.qait.automation.hris.automation.TestSessionInitiator;
import com.qait.automation.hris.automation.WebDrivers;
import com.qait.automation.hris.utils.LocatorReader;

public class HomePageActions {

	File file;
	File newfile;
	InputStream yamlfile;
	Yaml yaml;
	String url;
	String title;
	Map<String, Object> yamlreader;
	Map<String, String> userdetails;
	WebDrivers wd = new WebDrivers();
	WebDriver myDriver;
	TestSessionInitiator ti;
	LocatorReader lr;
	String username;
	String password;

	@Test
	public void ReadYamlFile() throws FileNotFoundException {
		file = new File("src/test/resources/hris.yml");
		newfile = new File("src/test/resources/newfile.yml");

		yamlfile = new FileInputStream(file);
		yaml = new Yaml();
		yamlreader = (Map<String, Object>) yaml.load(yamlfile);
		url = (String) yamlreader.get("base_url");
		title = (String) yamlreader.get("landingPageTitle");

		userdetails = (Map<String, String>) yamlreader.get("credentials");

		String username = userdetails.get("username");
		String password = userdetails.get("password");

	}


	public void Login() throws IOException {
		ti = new TestSessionInitiator();

		myDriver.get("https://hris.qainfotech.com/login.php");
		myDriver.findElement(lr.getlocator("tab_loginPage")).click();
		myDriver.findElement(lr.getlocator("input_username")).sendKeys(username);
		myDriver.findElement(lr.getlocator("input_password")).sendKeys(password);
		myDriver.findElement(lr.getlocator("loginPage_submitButton")).click();
	}

	public void getData() throws IOException {
		String ginfo = myDriver.findElement(lr.getlocator("generalinfo_tab")).getText();
		String cinfo = myDriver.findElement(lr.getlocator("contactinfo_tab")).getText();

		HashMap<String, HashMap<String, String>> generalInfomap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> infomap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> coInfomap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> contactinfomap = new HashMap<String, String>();

		List<WebElement> generalinfoelements = myDriver.findElements(lr.getlocator("generalinfo_elementList"));
		List<WebElement> contactinfoelements = myDriver.findElements(lr.getlocator("contactinfo_elementList"));

		for (WebElement ele : generalinfoelements) {
			// System.out.println(ele.getText());
			String key = ele.findElement(lr.getlocator("generalinfo_key")).getText();
			String value = ele.findElement(lr.getlocator("generalinfo_value")).getText();

			infomap.put(key, value);
		}
		for (WebElement ele : contactinfoelements) {
			// System.out.println(ele.getText());
			String key = ele.findElement(lr.getlocator("contactinfo_key")).getText();
			String value = ele.findElement(lr.getlocator("contactinfo_value")).getText();

			contactinfomap.put(key, value);
		}

		System.out.println(contactinfomap);

		generalInfomap.put(ginfo, infomap);
		coInfomap.put(cinfo, contactinfomap);

	}

	public void quitBrowser() {
		myDriver.quit();
	}
}
