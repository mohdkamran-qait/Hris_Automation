package com.qait.automation.hris.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;

public class LocatorReader {

	File specFile = null;

	public LocatorReader(String specFile) {
		// TODO Auto-generated constructor stub
		this.specFile = new File(specFile);
	}

	public By getlocator(String elementName) throws IOException {
		By by = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(specFile));
			String str;
			boolean flag = true;
			System.out.println(elementName);
			while ((str = br.readLine()) != null && flag) {
				// System.out.println(str);
				str = str.replaceAll("[ \t]+", " ");
				String[] st = str.split(" ", 3);
			//	System.out.println(st.length + " >>>>>>>>>>>");

				// System.out.println(st[0] + "..........a");
				// System.out.println(st[1] + ".............b");
				// System.out.println(st[2] + ".................c");
				if (st[0].equals(elementName)) {
					by = getBy(st[1], st[2]);
					// System.out.println(st[0] + "..........a");
					// System.out.println(st[1] + ".............b");
					// System.out.println(st[2] + ".................c");
					flag = false;
					return by;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return by;
	}

	private By getBy(String locatorType, String locator) {
		switch (locatorType) {

		case "xpath":
			return By.xpath(locator);

		case "css":
			return By.cssSelector(locator);

		case "id":
			return By.id(locator);

		case "link":
			return By.linkText(locator);

		case "classname":
			return By.className(locator);

		case "name":
			return By.name(locator);

		case "partiallink":
			return By.partialLinkText(locator);

		case "tagname":
			return By.tagName(locator);
		}

		return null;
	}

	// public static void main(String... args) throws IOException {
	// LocatorReader lr = new
	// LocatorReader("src/test/resources/locators/locators.spec");
	// lr.getlocator("tab_loginPage");
	// }
}