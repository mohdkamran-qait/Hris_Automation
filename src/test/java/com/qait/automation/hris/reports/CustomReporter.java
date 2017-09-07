package com.qait.automation.hris.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

import com.qait.automation.hris.utils.ExcelSheetReader;
import com.qait.automation.hris.utils.Quickstart;

public class CustomReporter implements IReporter {

	private PrintWriter writer;
	private String reportTitle = "TestNG Customized Report";
	private String reportFileName = "customizedreport.html";
	public ExcelSheetReader sr;
	

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outdir) {
		try {
			writer = createWriter(outdir);
		} catch (IOException e) {
			System.err.println("Unable to create output file");
			e.printStackTrace();
			return;
		}
		try {
			getTestCaseDetails();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		startHtml(writer);
		writeReportTitle(reportTitle);
		try {
			generateReport(suites);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// generateSuiteSummaryReport(suites);
		// generateMethodSummaryReport(suites);
		// generateMethodDetailReport(suites);
		// endHtml(writer);
		writer.flush();
		writer.close();
	}

	private void getTestCaseDetails() throws IOException {
		// TODO Auto-generated method stub
		ExcelSheetReader.readexcelfile();
	}

	/**
	 * 
	 * @param outdir
	 * @return
	 * @throws IOException
	 */
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFileName))));
	}

	/**
	 * 
	 * @param title
	 */
	protected void writeReportTitle(String title) {
		writer.print("<center><h1>" + title + " - " + getDateAsString() + "</h1></center>");
		writer.print("<center><h1>" + "----------------------------------------------------------------------" + "</h1></center>");
	}

	/**
	 * 
	 * @return
	 */
	private String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	
	private void resultDetail(IResultMap tests) {
		int methodIndex=0;
		for (ITestResult result : tests.getAllResults()) {
		ITestNGMethod method = result.getMethod();
		String cname = method.getTestClass().getName();
		writer.print("<h2 id=\"m" + methodIndex + "\">" + cname + ":"
		+ method.getMethodName() + "</h2>");
		Set<ITestResult> resultSet = tests.getResults(method);
		}
		}
	
	
	
	
	private void generateReport(List<ISuite> suites) throws IOException {
		// TODO Auto-generated method stub
		writer.print("<center><h2>" + "TEST SUMMARY" + "</h1></center>");
		
		
		for(int i=0;i<3;i++){
		writer.print("<table width='75%' border = '1'>"+
				"<tr> " + 
						"<td>" + "Test ID" + "</td>" +
						"<td>" + "Test Name"+ "</td>" + 
						"<td>" + "TestDesc"+ "</td>" +
				"</tr>"+
						
				"<tr> " + 
					"<td>" + "T01" + "</td>" +
					"<td>" + "T1"+ "</td>" + 
					"<td>" + "a"+ "</td>" +
				"</tr>"+
					
				"<tr> " + 
					"<td>" + "T01" + "</td>" +
					"<td>" + "T1"+ "</td>" + 
					"<td>" + "a"+ "</td>" +
				"</tr>"+
						
				
					
				
						"</table>");
		
		}	
		
	}

	/**
	 * 
	 * @param out
	 */
	protected void startHtml(PrintWriter out) {

		out.println(
				"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.1//EN' 'http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd'>");
		out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
		out.println("<head>");
		out.println("<title>TestNG Report</title>");
		out.println("<style type='text/css'>");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td {background-color: #3F3}");
		out.println(".skippedodd td {background-color: #CCC}");
		out.println(".skippedodd td {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

	}

}


