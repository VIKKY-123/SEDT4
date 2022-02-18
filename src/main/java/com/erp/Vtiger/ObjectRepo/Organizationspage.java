package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
	WebDriver driver; 
	@FindBy(xpath="//img[@alt=\"Create Organization...\"]") private WebElement createorgimg;
	@FindBy(xpath="//input[@class=\"txtBox\"]") private WebElement org_serach_field;
	@FindBy(xpath="//input[@name=\"submit\"]") private WebElement submitbtn;
	@FindBy(xpath="//select[@name=\"search_field\"]") private WebElement orgsearchfield;
	public WebElement getCreateorgimg() {
		return createorgimg;
	}
	public WebElement getOrg_serach_field() {
		return org_serach_field;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public WebElement getOrgsearchfield() {
		return orgsearchfield;
	}
public Organizationspage(WebDriver driver) {
	
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
}
}
