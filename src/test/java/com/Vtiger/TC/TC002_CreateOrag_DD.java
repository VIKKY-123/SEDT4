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

public class TC002_CreateOrag_DD extends Base_Class {
	@Test(groups={"regration"})
	public  void createorg_DD() throws InterruptedException, IOException {


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
		String value = organizationspage.getORGTitle().getText();

		System.out.println(value);

		Assert.assertEquals(value, orgname);







	}

}
