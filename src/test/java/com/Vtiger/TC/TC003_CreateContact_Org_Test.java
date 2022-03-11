package com.Vtiger.TC;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.erp.Vtiger.Base_Class;
import com.erp.Vtiger.JavaUtil;
import com.erp.Vtiger.ObjectRepo.ContactsPage;
import com.erp.Vtiger.ObjectRepo.Create_Contacts;
import com.erp.Vtiger.ObjectRepo.Homepage;
import com.erp.Vtiger.ObjectRepo.OrganizationPopup;

public class TC003_CreateContact_Org_Test extends Base_Class {
	@Test(groups= {"regression"})
	public void Create_contact_org_Test() throws Throwable {

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

		Set<String> wdw = driver.getWindowHandles();


		Iterator<String> itr = wdw.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);

		OrganizationPopup organizationpopup=new OrganizationPopup(driver);


String orgname="ABC_PARK";
		organizationpopup.getSearch_text().sendKeys(orgname);
		WebElement DDsearchfield = organizationpopup.getSearch_fieldDD();

		webutil.selectfromDD(DDsearchfield, "Organization Name");


		organizationpopup.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='ABC_PARK123']")).click();
		
		//organizationpopup.getContact_optin().click();
		
		Thread.sleep(2000);

		driver.switchTo().window(parent);	

		createcontacts.getSavebtn().click();
		Thread.sleep(2000);

		homepage.getContactlink().click();

		contactspage.getTxtbox().sendKeys(firstname);
		WebElement addsearchfield = contactspage.getSearchfield();

		webutil.selectfromDD(addsearchfield, "First Name");

		contactspage.getSubmitbtn().click();
		
		
		Thread.sleep(2000);

		String value =driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).getText();

		System.out.println(value);
		Assert.assertEquals(value, firstname);

	}
	
	
	@Test(enabled = false,   groups= {"smoke"})
	public void create_Contact_Test() throws InterruptedException {
		
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
		
		createcontacts.getSavebtn().click();
		Thread.sleep(2000);

		homepage.getContactlink().click();

		contactspage.getTxtbox().sendKeys(firstname);
		WebElement addsearchfield = contactspage.getSearchfield();

		webutil.selectfromDD(addsearchfield, "First Name");

		contactspage.getSubmitbtn().click();
		Thread.sleep(3000);
		
		String value = driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).getText();
				
		Assert.assertEquals(value, firstname);
		

		
	}

}
