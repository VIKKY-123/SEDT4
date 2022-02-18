package com.Vtiger.TC;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.erp.Vtiger.ExcelUtil;
import com.erp.Vtiger.FileLib;
import com.erp.Vtiger.JavaUtil;
import com.erp.Vtiger.WebDriverUility;
import com.erp.Vtiger.ObjectRepo.ContactsPage;
import com.erp.Vtiger.ObjectRepo.Create_Contacts;
import com.erp.Vtiger.ObjectRepo.Homepage;
import com.erp.Vtiger.ObjectRepo.LoginPage;
import com.erp.Vtiger.ObjectRepo.OrganizationPopup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_CreateContact_Org {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();


		WebDriver driver;

		FileLib fil=new FileLib();

		String BROWSER =fil.readpropertieData("browser");

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





		driver.get(fil.readpropertieData("URL"));
		driver.manage().window().maximize();
		WebDriverUility webutil=new WebDriverUility();

		webutil.pageloadedwait(driver);

		LoginPage loginpage=new LoginPage(driver);


		loginpage.getUsername().sendKeys(fil.readpropertieData("un"));
		loginpage.getPassword().sendKeys(fil.readpropertieData("pwd"));
		loginpage.getLoginbtn().click();

		Thread.sleep(3000);

		Homepage homepage= new Homepage(driver);

		homepage.getContactlink().click();
		ContactsPage contactspage=new ContactsPage(driver);
		contactspage.getCreate_contact().click();


		Create_Contacts createcontacts=new Create_Contacts(driver);
		WebElement addDD = createcontacts.getSalutationDD();

		webutil.selectfromDD(addDD, "Mr." );


		JavaUtil jv=new JavaUtil();
		String firstname = jv.fakefirstName();
		String lastname = jv.fakelastName();

		createcontacts.getFirstnametext().sendKeys(firstname);
		createcontacts.getLastnametext().sendKeys(lastname);
		createcontacts.getAccountnamebtn().click();	


		Thread.sleep(5000);



		//
		Set<String> wdw = driver.getWindowHandles();

		//	for(String singlewin:wdw) {
		//		
		//		String title = driver.switchTo().window(singlewin).getTitle();
		//		
		//		System.out.println(title);
		//		
		//	
		//	
		//	}
		Iterator<String> itr = wdw.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);

		OrganizationPopup organizationpopup=new OrganizationPopup(driver);



		organizationpopup.getSearch_text().sendKeys(firstname);
		WebElement DDsearchfield = organizationpopup.getSearch_fieldDD();

		webutil.selectfromDD(DDsearchfield, "Organization Name");


		organizationpopup.getSearchbtn();

		organizationpopup.getContact_optin().click();

		driver.switchTo().window(parent);

		Thread.sleep(3000);

		createcontacts.getSavebtn().click();


		Thread.sleep(5000);

		homepage.getContactlink().click();

		contactspage.getTxtbox().sendKeys(firstname);
		WebElement addsearchfield = contactspage.getSearchfield();

		webutil.selectfromDD(addsearchfield, "First Name");

		contactspage.getSubmitbtn().click();

		ExcelUtil excelutil=new ExcelUtil();
		String orgname = excelutil.getExcelData("sheet1", 2, 0);








		//String orgname = companyname+jv.generaterandomNumber();




		String value = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();

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
