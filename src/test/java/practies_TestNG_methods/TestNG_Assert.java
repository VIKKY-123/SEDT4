package practies_TestNG_methods;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assert {
	@Test
	public void a() {
		
		System.out.println("Launch Broswer");
		System.out.println("Get URL");
		System.out.println("Login");
		
		//Assert.assertEquals(false, true);
		
		
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(true, false);
		
		System.out.println("Test Step 1");
		System.out.println("Test Step 2");
		System.out.println("Test Step 3");
		
		System.out.println("Test Step 4");
		System.out.println("Test Step 5");
		System.out.println("Test Step 6");
		System.out.println("Close Browser");
		assert1.assertAll();
	}


}
