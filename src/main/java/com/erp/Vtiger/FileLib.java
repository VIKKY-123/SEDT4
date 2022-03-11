package com.erp.Vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLib {
	
	public String readpropertieData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IAutoConstants.pro_path);
		Properties pro=new Properties();
		pro.load(fis);
		
		return pro.getProperty(key, "inccorect key");
	}

}
