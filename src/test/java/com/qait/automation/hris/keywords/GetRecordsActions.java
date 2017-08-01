package com.qait.automation.hris.keywords;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qait.automation.hris.utils.LocatorReader;

public class GetRecordsActions {

	WebDriver driver;
	LocatorReader lr;

	public GetRecordsActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.lr = new LocatorReader("src/test/resources/locators/locators.spec");
	}

	public void getRecords() throws IOException {

		String ginfo = driver.findElement(lr.getlocator("generalinfo_tab")).getText();
		String cinfo = driver.findElement(lr.getlocator("contactinfo_tab")).getText();

		HashMap<String, HashMap<String, String>> generalInfomap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> infomap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> coInfomap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> contactinfomap = new HashMap<String, String>();

		List<WebElement> generalinfoelements = driver.findElements(lr.getlocator("generalinfo_elementList"));
		List<WebElement> contactinfoelements = driver.findElements(lr.getlocator("contactinfo_elementList"));

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

	//	System.out.println(contactinfomap);

		generalInfomap.put(ginfo, infomap);
		coInfomap.put(cinfo, contactinfomap);
		driver.quit();
	}

}
