package demo;

import org.testng.annotations.Test;

import utils.ExcelDriver;

public class DemoExcelDriver {
	
	ExcelDriver excelDriver;
	String filename ="C:\\Users\\Manoj Adhikari\\eclipse-workspace\\modularFramework-06082019\\inputFile\\TestData.xsl";
    String sheetname = "Test Data";	
	
	
	
	@Test
	public void verifyExcelDriver() throws Exception {
		excelDriver = new ExcelDriver();
		
		excelDriver.createSheet(filename);
		
		excelDriver.openWorkbook(filename);
	
		excelDriver.createSheet(sheetname);
		
		excelDriver.setCellData(sheetname,0 , 0, "Manoj");
		excelDriver.setCellData(sheetname,0 , 1, "Kumud");
		excelDriver.setCellData(sheetname,1 , 0, "Kanmal");
		excelDriver.setCellData(sheetname,1 , 1, "Surti");
		excelDriver.setCellData(sheetname,2 , 0, "Sefali");
		excelDriver.setCellData(sheetname,2 , 1, "Saurab");
		
		excelDriver.saveFile();
		excelDriver.closeWorkbook();
		
		
		
		
		}
	
				
	}


