package in.amazon.utils;

import org.testng.annotations.DataProvider;

import utils.ExcelDriver;

public class TestDataReader {
	
ExcelDriver excelDriver;
	
	String excelWorkbook;
	String excelSheetname;

	@DataProvider
	public Object[][] getData() throws Exception{
		
		excelWorkbook = System.getProperty("user.dir") + "/testData/TestData.xlsx";
		
		excelSheetname = "TestData";
		
		excelDriver = new ExcelDriver();
		
		excelDriver.openWorkbook(excelWorkbook);
		
		int rowCount = excelDriver.getRowCount(excelSheetname);
		int cellCount = excelDriver.getCellCount(excelSheetname, 0);
		
		Object[][] data = new Object[rowCount+1][cellCount];
		
		for(int row=0; row <= rowCount; row++) {
			for(int cell=0; cell < cellCount; cell++){
				data[row][cell] = excelDriver.getCellData(excelSheetname, row, cell);
			}
		}
		
		return data;
	}

	
	

}
