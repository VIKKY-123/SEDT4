package practies_TestNG_methods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShort {
	@Test
	public void takeScreenShort() throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://amazon.in");
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String dest = System.getProperty("user.dir")+"/Screenshorts/"+"Amazon"+".png";
	File file=new File(dest);
	FileUtils.copyFile(src, file);
		
	}

}
