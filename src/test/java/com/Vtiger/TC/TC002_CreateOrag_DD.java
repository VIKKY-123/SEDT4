package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.erp.Vtiger.IAutoConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrag_DD {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		FileInputStream fis = new FileInputStream(IAutoConstants.pro_path);
		Properties pro= new Properties();
		pro.load(fis);

		String BROWSER = pro.getProperty("brower");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();

		}




		driver.get(pro.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.name("user_name")).sendKeys(pro.getProperty("un"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getProperty("pwd"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		
		Thread.sleep(3000);
		
		FileInputStream fisexl=new FileInputStream(IAutoConstants.ex_path);
		String orgname=WorkbookFactory.create(fisexl).getSheet("sheet1").getRow(3).getCell(0).getStringCellValue();

		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);


		WebElement inst = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		WebElement rati = driver.findElement(By.xpath("//select[@name=\"rating\"]"));


		WebElement type = driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));

		Select sel_inst=new Select(inst);
		sel_inst.selectByVisibleText("Hospitality");

		Select sel_rati = new Select(rati);
		sel_rati.selectByIndex(2);

		Select sel_type=new Select(type);

		sel_type.selectByVisibleText("Customer");


		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(orgname);

		Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"search_field\"]")));

		sel.selectByVisibleText("Organization Name");

		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[test()='VIKKY']")
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);

		if(value.equalsIgnoreCase(orgname))
		{
			System.out.println("testcase is pass");
		}
		else {
			System.out.println("Testcase is fail");
		}

		WebElement sp = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions mv=new Actions(driver);
		mv.moveToElement(sp).build().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		Thread.sleep(10000);


		driver.close();







	}

}
