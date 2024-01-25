package com.shoppersstack.excelreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {
	private final static String EXCEL_PATH = "./src/test/resources/TestData/LoginTestData.xlsx";

	public static ArrayList<String> getAllTestCasses() {
		try {
			FileInputStream fin = new FileInputStream(EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(fin);
			Sheet sheet = workbook.getSheet("TestCases");
			ArrayList<String> testCasses = new ArrayList<String>();

			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowCount; i++) {
				testCasses.add(sheet.getRow(i).getCell(0).toString());
			}
			return testCasses;
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getAllKeyWords(String sheetName) {
		try {
			FileInputStream fin = new FileInputStream(EXCEL_PATH);
			Workbook workbook = WorkbookFactory.create(fin);
			Sheet sheet = workbook.getSheet(sheetName);
			ArrayList<String> testCasses = new ArrayList<String>();

			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowCount; i++) {
				testCasses.add(sheet.getRow(i).getCell(6).toString());
			}
			return testCasses;
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTestData(String sheetName, int rowNum) {
		try {
			FileInputStream fis = new FileInputStream(EXCEL_PATH);
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet(sheetName);
			return sh.getRow(rowNum).getCell(5).toString();
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getLocators(String sheetName, int rowNum) {

		try {
			FileInputStream fis = new FileInputStream(EXCEL_PATH);
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet(sheetName);
			return sh.getRow(rowNum).getCell(7).toString();
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

}
