package practies_TestNG_methods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProveder_Excel {
	
	@Test(dataProvider = "read")

	public void read_excel_data(String username, String password ) {

		System.out.println(username + " "+ password);



	}

	@DataProvider
	public Object[][] read() throws EncryptedDocumentException, IOException {

		FileInputStream fis =new FileInputStream("D:\\New folder\\kcda42\\com.erp.Vtiger\\Excel.xlsx");
		int lastrow = WorkbookFactory.create(fis).getSheet("Sheet2").getLastRowNum();
		short lastcell = WorkbookFactory.create(fis).getSheet("sheet2").getRow(1).getLastCellNum();
		System.out.println(lastrow);
		System.out.println(lastcell);
		Object arr[] []=new Object[lastrow][2];

		for (int i = 0; i < lastrow; i++) {

			arr[i][0]= WorkbookFactory.create(fis).getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue();
			arr[i][1]= WorkbookFactory.create(fis).getSheet("Sheet2").getRow(i).getCell(1).getStringCellValue();


		}
		return arr;


	}
}
