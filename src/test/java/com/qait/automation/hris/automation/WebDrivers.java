package com.qait.automation.hris.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDrivers {

	public Properties properties = null;
	public InputStream input = null;
	public String browser;
	public final String DRIVERPATH = "src/test/resources/drivers";

	public void load_config_properties_file() throws FileNotFoundException {

		String resource_file_path = "C:\\Users\\mohdkamran\\workspace\\hris.automation\\src\\test\\resources\\config.properties";
		try {

			properties = new Properties();
			input = new FileInputStream(resource_file_path);
			properties.load(input);
			browser = properties.getProperty("BrowserName");
//			driverpath = properties.getProperty("driverpath");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getBrowserName() {
		return browser;
	}

	public String getDriverPath() {
		return DRIVERPATH;
	}

	public WebDriver getBrowser() {
		if (browser.equalsIgnoreCase("chrome"))
			return getChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			return getFirefoxDriver();
		else if (browser.equalsIgnoreCase("internet explorer"))
			return getInternetExplorerDriver();
		else if (browser.equalsIgnoreCase("opera"))
			return getOperaDriver();
		else if (browser.equalsIgnoreCase("safari"))
			return getSafariDriver();
		return null;
	}

	private WebDriver getSafariDriver() {
		System.setProperty("webdriver.safari.driver", DRIVERPATH + "/safari.exe");
		return new SafariDriver();
	}

	private WebDriver getOperaDriver() {
		System.setProperty("webdriver.firefox.driver", DRIVERPATH + "/operadriver.exe");
		return getOperaDriver();
	}

	private WebDriver getInternetExplorerDriver() {
		System.setProperty("webdriver.ie.driver", DRIVERPATH + "/IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

	private WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", DRIVERPATH + "/geckodriver.exe");
		return new FirefoxDriver();
	}

	private WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", DRIVERPATH + "/chromedriver.exe");
		return new ChromeDriver();
	}

}
