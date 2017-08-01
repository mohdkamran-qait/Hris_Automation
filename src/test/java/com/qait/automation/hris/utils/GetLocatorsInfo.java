package com.qait.automation.hris.utils;

import java.util.Map;

public class GetLocatorsInfo {

	private static String locatorName;
	private static String locatorType;
	private static String locatorSyntax;

	public GetLocatorsInfo (String locatorName , String locatorType, String locatorSyntax){
	
	    this.locatorName = locatorName;
	    this.locatorType = locatorType;
	    this.locatorSyntax = locatorSyntax;
	}

	public String getLocatorName() {
		return locatorName;
	}

	public String getLocatorType() {
		return locatorType;
	}

	public String getPath() {
		return locatorSyntax;
	}
}
