package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class TC003_CreateContact_Org {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();


		WebDriver driver;
		FileInputStream fis = new FileInputStream(IAutoConstants.pro_path);
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
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

		Thread.sleep(3000);


		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		Select sel = new Select(driver.findElement(By.xpath("//select[@name=\"salutationtype\"]")));
		sel.selectByVisibleText("Mr.");
		
		FileInputStream fisexl=new FileInputStream(IAutoConstants.ex_path);
		
		String contatname=WorkbookFactory.create(fisexl).getSheet("sheet2").getRow(1).getCell(0).getStringCellValue();
		
		System.out.println(contatname);
		FileInputStream fisexl2=new FileInputStream(IAutoConstants.ex_path);
		
		String lastname=WorkbookFactory.create(fisexl2).getSheet("sheet2").getRow(1).getCell(1).getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(contatname);
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastname);

		driver.findElement(By.xpath("//input[@name=\"account_name\"]/../img")).click();

		Thread.sleep(5000);

		Set<String> wdw = driver.getWindowHandles();
		Iterator<String> itr = wdw.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);

		driver.findElement(By.xpath("//input[@id=\"search_txt\"]")).sendKeys(contatname);

		Select selchildDD = new Select(driver.findElement(By.xpath("//select[@name=\"search_field\"]")));
		selchildDD.selectByVisibleText("Organization Name");

		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();

		driver.findElement(By.xpath("//a[@id='2']")).click();
		driver.switchTo().window(parent);


		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		Thread.sleep(5000);


		driver.findElement(By.xpath("//a[text()='Contacts']")).click();


		driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(contatname);

		Select selDD = new Select(driver.findElement(By.xpath("//select[@id=\"bas_searchfield\"]")));

		selDD.selectByVisibleText("First Name");


		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

		FileInputStream fisexl1=new FileInputStream(IAutoConstants.ex_path);
		String orgname=WorkbookFactory.create(fisexl1).getSheet("sheet1").getRow(2).getCell(0).getStringCellValue();

		String value = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();

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
