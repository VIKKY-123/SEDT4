package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
@FindBy(xpath="//a[text()=\"Organizations\"]") private WebElement orgalink;
@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement singupimg;
@FindBy(xpath="//a[text()='Sign Out']") private WebElement singupbtn;
@FindBy(xpath="//a[text()='Contacts']") private WebElement contactlink;
public WebElement getContactlink() {
	return contactlink;
}
public WebElement getSingupbtn() {
	return singupbtn;
}
public WebElement getOrgalink() {
	return orgalink;
}
public WebElement getSingupimg() {
	return singupimg;
}

public Homepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

}
