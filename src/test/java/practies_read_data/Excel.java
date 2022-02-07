package practies_read_data;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("D:\\New folder\\kcda42\\com.erp.Vtiger\\Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
	
		
		//System.out.println(value);
		int rowcount = wb.getSheet("sheet1").getLastRowNum();
		
		// ArrayList<String> ar = new ArrayList<String>();
		
		for(int i=1;i<=rowcount;i++) {
			double sal = wb.getSheet("sheet2").getRow(i).getCell(1).getNumericCellValue();
			
			
			if(sal>=50000) {
				String name = wb.getSheet("sheet2").getRow(i).getCell(0).getStringCellValue();
				//ar.add(name);
			System.out.println(name +" salary is " + sal);
			}
			//Collections.sort(ar);
			//System.out.println(ar);
		}
		
		
	}

}
