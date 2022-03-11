package com.erp.Vtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.erp.Vtiger.ObjectRepo.Homepage;
import com.erp.Vtiger.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public WebDriver driver;
	public FileLib fil=new FileLib();
	public WebDriverUility webutil=new WebDriverUility();

	@BeforeSuite(groups= {"smoke","regretion"})
	public void connection_DB() {
		System.out.println("===Connection_DataBase===");
	}
//	@BeforeTest
//	public void before_test() {
//
//		Reporter.log("===execute before test");
//	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regretion"})
	public void Open_Browser( ) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		String BROWSER = fil.readpropertieData("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
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

	}
	
	@BeforeMethod(groups= {"smoke","regretion"})
	public void login_page() throws IOException {
		driver.get(fil.readpropertieData("URL"));
		driver.manage().window().maximize();
		
		webutil.pageloadedwait(driver);
		

		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsername().sendKeys(fil.readpropertieData("un"));
		loginpage.getPassword().sendKeys(fil.readpropertieData("pwd"));
		loginpage.getLoginbtn().click();
	}
	
	@AfterMethod(groups= {"smoke","regretion"})
	public void page_logout() throws InterruptedException {
		
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		
		WebElement sp = homepage.getSingupimg();
		Actions mv=new Actions(driver);
		mv.moveToElement(sp).build().perform();
		homepage.getSingupbtn().click();
	}
	
	@AfterClass(groups= {"smoke","regretion"})
	
	public void Close_Browser() throws InterruptedException {
		Thread.sleep(10000);
		
		driver.close();
		
		
	}
	@AfterSuite(groups= {"smoke","regretion"})
	
	public void disconnectDBconnection() {
		
		Reporter.log("dis connect Data Base Connections");
	}
	
}
