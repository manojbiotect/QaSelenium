package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	private InputStream fileReader;

	private OutputStream fileWriter;

	private Workbook excelWorkbook;

	private String excelfilename;

	public void createWorkbook(String filename) throws Exception {
		filename = filename.trim();

		File file = new File(filename);

		if (file.exists()) {
			throw new Exception("File already exist.. choose a new name");
		}

		if (filename.endsWith(".xls")) {
			excelWorkbook = new HSSFWorkbook();
		} else if (filename.endsWith(".xlsx")) {
			excelWorkbook = new XSSFWorkbook();
		} else {
			throw new Exception("Invalid file type");
		}

		fileWriter = new FileOutputStream(filename);

		excelWorkbook.write(fileWriter);

		fileWriter.close();

		excelWorkbook.close();
	}

	public void openWorkbook(String filename) throws Exception {

		filename = filename.trim();

		excelfilename = filename;

		File file = new File(filename);

		if (!file.exists()) {
			throw new Exception("File doesnot exists..");
		}

		fileReader = new FileInputStream(filename);

		excelWorkbook = WorkbookFactory.create(fileReader);
	}

	public void createSheet(String sheetname) throws Exception {
		sheetname = sheetname.trim();

		Sheet sheet = excelWorkbook.getSheet(sheetname);

		if (sheet != null) {
			throw new Exception("Sheet already exist..");
		}

		excelWorkbook.createSheet(sheetname);
	}

	public int getRowCount(String sheetname) throws Exception {

		sheetname = sheetname.trim();

		Sheet sheet = excelWorkbook.getSheet(sheetname);

		if (sheet == null) {
			throw new Exception("Sheet doesnot exist..");
		}

		return sheet.getLastRowNum();
	}

	public int getCellCount(String sheetname, int rowNumber) throws Exception {

		sheetname = sheetname.trim();

		Sheet sheet = excelWorkbook.getSheet(sheetname);

		if (sheet == null) {
			throw new Exception("Sheet doesnot exist..");
		}

		if (rowNumber < 0) {
			throw new Exception("Invalid row number...");
		}

		Row row;

		row = sheet.getRow(rowNumber);

		if (row == null) {
			return 0;
		} else {
			return row.getLastCellNum();
		}
	}

	public String getCellData(String sheetname, int rowNumber, int cellNumber) throws Exception {

		sheetname = sheetname.trim();

		Sheet sheet = excelWorkbook.getSheet(sheetname);

		if (sheet == null) {
			throw new Exception("Sheet doesnot exist..");
		}

		if (rowNumber < 0 || cellNumber < 0) {
			throw new Exception("Invalid row or cell number...");
		}

		Row row;

		row = sheet.getRow(rowNumber);

		if (row == null) {
			return "";
		}

		Cell cell = row.getCell(cellNumber);

		if (cell == null) {
			return "";
		} else {

			if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else {
				return cell.getStringCellValue();
			}

		}

	}

	public void setCellData(String sheetname, int rowNumber, int cellNumber, String text) throws Exception {

		sheetname = sheetname.trim();

		Sheet sheet = excelWorkbook.getSheet(sheetname);

		if (sheet == null) {
			throw new Exception("Sheet doesnot exist..");
		}

		if (rowNumber < 0 || cellNumber < 0) {
			throw new Exception("Invalid row or cell number...");
		}

		Row row;

		row = sheet.getRow(rowNumber);

		if (row == null) {
			sheet.createRow(rowNumber);

			row = sheet.getRow(rowNumber);
		}

		Cell cell = row.getCell(rowNumber);

		if (cell == null) {
			cell = row.createCell(cellNumber);

			cell = row.getCell(cellNumber);
		}

		cell.setCellValue(text);

	}

	public void saveFile() throws Exception {
		fileWriter = new FileOutputStream(excelfilename);

		excelWorkbook.write(fileWriter);

		fileWriter.close();
	}

	public void saveAsFile(String newFilename) throws Exception {
		newFilename = newFilename.trim();

		File file = new File(newFilename);

		if (file.exists()) {
			throw new Exception("File already exists...");
		}

		fileWriter = new FileOutputStream(newFilename);

		excelWorkbook.close();

		fileWriter.close();
	}

	public void closeWorkbook() throws Exception {
		fileReader.close();

		fileWriter.close();
		excelWorkbook.close();
	}



}
