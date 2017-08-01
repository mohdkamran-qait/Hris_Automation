package com.qait.automation.hris.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class SpecFileReader {
	public String username;
	public String password;

	public String loadusername() throws FileNotFoundException {
		// lr = new LocatorReader("");
		// lr = new LocatorReader("src/test/resources/locators/locators.spec");
		File file = new File("src/test/resources/hris.yml");

		InputStream yamlfile = new FileInputStream(file);
		Yaml yaml = new Yaml();

		Map<String, Object> yamlreader = (Map<String, Object>) yaml.load(yamlfile);

		String url = (String) yamlreader.get("base_url");
		String title = (String) yamlreader.get("landingPageTitle");

		Map<String, String> userdetails = (Map<String, String>) yamlreader.get("credentials");

		username = userdetails.get("username");
		password = userdetails.get("password");
		
		return username ;

	}

	
	public String loadpassword() throws FileNotFoundException {
		// lr = new LocatorReader("");
		// lr = new LocatorReader("src/test/resources/locators/locators.spec");
		File file = new File("src/test/resources/hris.yml");

		InputStream yamlfile = new FileInputStream(file);
		Yaml yaml = new Yaml();

		Map<String, Object> yamlreader = (Map<String, Object>) yaml.load(yamlfile);

		String url = (String) yamlreader.get("base_url");
		String title = (String) yamlreader.get("landingPageTitle");

		Map<String, String> userdetails = (Map<String, String>) yamlreader.get("credentials");

		username = userdetails.get("username");
		password = userdetails.get("password");
		
		return password ;

	}

	
	
	
	
	
	
	
	
	
}
