package practies_TestNG_methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.erp.Vtiger.IAutoConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Att {
	@Test
	public void smarthwatches() throws IOException, InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.att.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//span[text()='Phones & devices']")).click();
		driver.findElement(By.xpath("//a[@id=\"Categories-3\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-label=\"Compare\"]")).click();
		Thread.sleep(2000);

		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.xpath("//a[@id=\"product_card"+i+"\"]/ancestor::div[@class=\"flex\"]//input")).click();

		}
		
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
	

		TakesScreenshot takescrshrt = (TakesScreenshot)driver;
		File src = takescrshrt.getScreenshotAs(OutputType.FILE);
		File dest=new File("user.dir"+"/ScreenShort1"+"compare1"+".png");
		FileUtils.copyFile(src, dest);

		driver.findElement(By.xpath("//div[@id=\"deviceLabel4\"]/.")).click();

		driver.findElement(By.xpath("//div[@id=\"deviceCta2\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"StarlightAluminumPlatinumBlackSport\"]")).click();

		File src2 = takescrshrt.getScreenshotAs(OutputType.FILE);
		File dest2=new File("user.dir"+"/ScreenShort1"+"Smartwatchdetatils"+".png");
		FileUtils.copyFile(src2, dest2);


		Point location = driver.findElement(By.xpath("//h2[text()='Pricing option']")).getLocation();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", location );

		File src3 = takescrshrt.getScreenshotAs(OutputType.FILE);
		File dest3=new File("user.dir"+"/ScreenShort1"+"Smartwatchdetatils_2"+".png");
		FileUtils.copyFile(src3, dest3);
		
		
		String priceOfProduct = driver.findElement(By.xpath("//span[text()='$529.99']")).getText();
  
		
		FileInputStream fis = new FileInputStream(IAutoConstants.ex_path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet3").getRow(1).createCell(1).setCellValue(priceOfProduct);
		
	FileOutputStream fos = new FileOutputStream(IAutoConstants.ex_path);	
		wb.write(fos);
		
		String rating = driver.findElement(By.xpath("//div[text()='4.7']")).getText();
		System.out.println(rating);
		
		
		














	}

}
