package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.erp.Vtiger.Base_Class;
import com.erp.Vtiger.JavaUtil;
import com.erp.Vtiger.ObjectRepo.Create_Org_page;
import com.erp.Vtiger.ObjectRepo.Homepage;
import com.erp.Vtiger.ObjectRepo.Organizationspage;

public class TC001_CreateOrganazation_Test extends Base_Class {
	
	@Test(groups= {"regression"})

	public void Create_organization_Test() throws IOException, InterruptedException {
			

		Homepage homepage=new Homepage(driver);
	
		homepage.getOrgalink().click();

		Organizationspage organizationspage = new Organizationspage(driver);

		organizationspage.getCreateorgimg().click();

		Thread.sleep(1000);

		JavaUtil jv=new JavaUtil();
		String orgname = jv.fakecompanyName();

		Create_Org_page create_org_page=new Create_Org_page(driver);
		create_org_page.getOrgtextfield().sendKeys(orgname);
		create_org_page.getOrg_save_btn().click();

		Thread.sleep(3000);
		homepage.getOrgalink().click();

		Thread.sleep(2000);
		organizationspage.getSearch_for().sendKeys(orgname);
		WebElement element = organizationspage.getOrg_serach_field();
		webutil.selectfromDD(element, "Organization Name");

		organizationspage.getSubmitbtn().click();
		Thread.sleep(3000);
		String value = organizationspage.getORGTitle().getText();
		System.out.println(value);

		Assert.assertEquals(value, orgname);


	}
	
	@Test(groups= {"smoke"})
	public void create_organization_Test() throws InterruptedException {
		
		Homepage homepage=new Homepage(driver);
		
		homepage.getOrgalink().click();

		Organizationspage organizationspage = new Organizationspage(driver);

		organizationspage.getCreateorgimg().click();


		Thread.sleep(2000);
		Create_Org_page create_org_page=new Create_Org_page(driver);
		
		create_org_page.getOrg_save_btn().click();
		
		String  message = webutil.getalertText(driver);
		
		Assert.assertEquals(message, "Organization Name cannot be empty");
		
		webutil.alertaccept(driver);
		
		
		
	}

}
