package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.erp.Vtiger.FileLib;
import com.erp.Vtiger.JavaUtil;
import com.erp.Vtiger.WebDriverUility;
import com.erp.Vtiger.ObjectRepo.Create_Org_page;
import com.erp.Vtiger.ObjectRepo.Homepage;
import com.erp.Vtiger.ObjectRepo.LoginPage;
import com.erp.Vtiger.ObjectRepo.Organizationspage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrag_DD {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		
		FileLib fil=new FileLib();

		String BROWSER = fil.readpropertieData("brower");

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




		driver.get(fil.readpropertieData("URL"));
		driver.manage().window().maximize();
		WebDriverUility webutil=new WebDriverUility();
		webutil.pageloadedwait(driver);
		
		


		LoginPage loginpage = new LoginPage(driver);

		loginpage.getUsername().sendKeys(fil.readpropertieData("un"));
		loginpage.getPassword().sendKeys(fil.readpropertieData("pwd"));
		loginpage.getLoginbtn().click();

		Homepage homepage=new Homepage(driver);
		Thread.sleep(3000);
		homepage.getOrgalink().click();

		Organizationspage organizationspage = new Organizationspage(driver);

		organizationspage.getCreateorgimg().click();


		Thread.sleep(3000);

		
		JavaUtil jv=new JavaUtil();
		String orgname = jv.fakecompanyName();



		Create_Org_page create_org_page=new Create_Org_page(driver);
		create_org_page.getOrgtextfield().sendKeys(orgname);
		
		WebElement inst =create_org_page.getIndustryDD();

		
		WebElement rati = create_org_page.getRatingDD();


		WebElement type = create_org_page.getAccounttypeDD();

		webutil.selectfromDD(inst, "Hospitality");
		webutil.selectfromDD(rati, 2);
		webutil.selectfromDD(type, "Customer");
		
		create_org_page.getOrg_save_btn().click();

		Thread.sleep(3000);
		
		homepage.getOrgalink().click();
		
		Thread.sleep(3000);
		
		organizationspage.getOrg_serach_field().sendKeys(orgname);

		WebElement org =organizationspage.getOrgsearchfield();


		webutil.selectfromDD(org,"Organization Name" );
		organizationspage.getSubmitbtn().click();


		
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);

		if(value.equalsIgnoreCase(orgname))
		{
			System.out.println("testcase is pass");
		}
		else {
			System.out.println("Testcase is fail");
		}

		WebElement sp = homepage.getSingupimg();

		webutil.movetoElement(driver, sp);

		homepage.getSingupbtn().click();

		Thread.sleep(10000);


		driver.close();







	}

}
