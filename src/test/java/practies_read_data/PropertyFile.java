package practies_read_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\New folder\\kcda42\\com.erp.Vtiger\\common.properties");
		Properties prop = new Properties();
		 prop.load(fis);
		String val = prop.getProperty("un", "INCORRECT KEY");
		System.out.println(val);
	

	}
}
