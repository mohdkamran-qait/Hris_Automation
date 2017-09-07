package com.qait.automation.hris.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelSheetReader {

	public static  <K, V> HashMap<K, V> readexcelfile() throws IOException {

		String excelfilepath = "src/test/resources/test.xls";
		InputStream ExcelFileToRead = new FileInputStream(excelfilepath);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheetAt(0);

		HashMap<String, HashMap<String, String>> TestCase = new HashMap<>();
		HashMap<String, String> TestCaseDetails = new HashMap<>();
		for (int i = 1; i <= 2; i++) {
			TestCaseDetails.put("testId", sheet.getRow(i).getCell(0).toString());
			TestCaseDetails.put("testName", sheet.getRow(i).getCell(1).toString());
			TestCaseDetails.put("testdesc", sheet.getRow(i).getCell(2).toString());

			TestCase.put(sheet.getRow(i).getCell(0).toString(), TestCaseDetails);
			TestCaseDetails = new HashMap<>();
		}

//		System.out.println(TestCase());
		return (HashMap<K, V>) TestCase;
		
	}

	public static void main(String args[]) throws IOException {
		readexcelfile();
System.out.println(readexcelfile());
	}

}
