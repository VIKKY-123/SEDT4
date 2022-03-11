package practies_TestNG_methods;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestNG_1 extends Base {
	
	@Test
	public void test_1() {
		Reporter.log("test_1 case executed", true);
		Reporter.log("click on organization", true);
		Reporter.log("Create the Organization", true);
		
	}
	
	@Test
	
	public void test_2() {
		Reporter.log("test_2 case executed", true);
	}


}
