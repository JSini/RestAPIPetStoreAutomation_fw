package com.fw.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="CreateUserData")
	public String[][] getAllData() throws Exception {
		
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		ReadExcelFile readXl = new ReadExcelFile(path);
		
		int rowNum = readXl.getRowCount("Sheet1");
		System.out.println(rowNum);
		int cellNum = readXl.getCellCount("Sheet1");
		System.out.println(cellNum);
		String[][] userData = new String[rowNum][cellNum];
		
		for (int i=1; i<=rowNum;i++) {
			for(int j=0; j<cellNum;j++) {
				userData[i-1][j]= readXl.getCellData("Sheet1", i, j);
			}
		}
		return userData;
		
	}
	
	@DataProvider(name="UsernameData")
	public String[] getUserNames() throws Exception {
		
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		ReadExcelFile readXl = new ReadExcelFile(path);
		
		int rowNum = readXl.getRowCount("Sheet1");
		String[] userNameData = new String[rowNum];
		
		for (int i=1; i<=rowNum;i++) {
			userNameData[i-1]=readXl.getCellData("Sheet1", i, 1);
		}
		
		return userNameData;
		
	}
}
