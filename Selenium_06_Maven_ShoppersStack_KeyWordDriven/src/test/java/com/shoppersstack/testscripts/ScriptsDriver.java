package com.shoppersstack.testscripts;

import java.util.ArrayList;

import com.shoppersstack.excelreader.ExcelDataReader;
import com.shoppersstack.utilitylibrary.KeyWordsUtility;

public class ScriptsDriver {
	
	public static void main(String[] args) {
		KeyWordsUtility keywords_Utility = new KeyWordsUtility();
		
		ArrayList<String> alltestCaseNames = ExcelDataReader.getAllTestCasses();
		
		for(String testCasename : alltestCaseNames)
		{
			
			ArrayList<String> allKeyWords = ExcelDataReader.getAllKeyWords(testCasename);
			
			int cellNumber=1;
			for(String keyword : allKeyWords)
			{
				switch (keyword) {
				case "launchBrowser":
					keywords_Utility.launchBrowser();
					break;
				case "enterUrl":
					keywords_Utility.enterUrl(ExcelDataReader.getTestData(testCasename, cellNumber));
					break;
				case "click":
					keywords_Utility.click(ExcelDataReader.getLocators(testCasename, cellNumber));
					break;
				case "enterData":
					keywords_Utility.enterData(ExcelDataReader.getLocators(testCasename, cellNumber), ExcelDataReader.getTestData(testCasename, cellNumber));
					break;
				case "verifyWebElement":
					keywords_Utility.verify(ExcelDataReader.getLocators(testCasename, cellNumber), testCasename);
					break;
				case "closeBrowser":
					keywords_Utility.closeBrowser();
					break;
				default:
					break;
				}
				cellNumber++;
			}
			
		}
	}

}
