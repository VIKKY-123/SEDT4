package com.erp.Vtiger;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	
	public String getExcelData(String sheet, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoConstants.ex_path);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}
}
