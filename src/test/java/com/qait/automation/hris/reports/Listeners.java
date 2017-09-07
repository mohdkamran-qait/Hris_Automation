package com.qait.automation.hris.reports;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@org.testng.annotations.Listeners
public class Listeners extends TestListenerAdapter {
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");
		log(tr.getTestClass());
		System.out.println("test is passed<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<.....");
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");
		System.out.println(".....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
		
	}

		
}
