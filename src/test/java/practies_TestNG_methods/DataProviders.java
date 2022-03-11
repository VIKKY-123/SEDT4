package practies_TestNG_methods;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@Test(dataProvider = "city")
	
	public void travel(String src, String dsc, String stop) {
		
		System.out.println(src + " " +dsc + " "+stop);
	}

	@DataProvider
	public Object[][] city(){
		
		Object arr[] []=new Object[4] [3];
		
		arr[0] [0]="vijayawada";
		arr[0] [1]="visakapatnam";
		arr[0] [2]="Eluru";
		
		arr[1] [0]="hyb";
		arr[1] [1]="vijayawada";
		arr[1] [2]="punukollu";
		
		arr[2] [0]="hyb";
		arr[2] [1]="blr";
		arr[2] [2]="maval";
		
		arr[3] [0]="hyb";
		arr[3] [1]="pune";
		arr[3] [2]="Zahirabad";
		
		return arr;
		
		
		
	}
}
