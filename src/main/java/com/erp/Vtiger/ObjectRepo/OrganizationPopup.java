package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopup {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id=\"search_txt\"]") private WebElement search_text;
	@FindBy(xpath="//select[@name=\"search_field\"]") private WebElement search_fieldDD;
	public WebElement getSearch_text() {
		return search_text;
	}
	public WebElement getSearch_fieldDD() {
		return search_fieldDD;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getContact_optin() {
		return contact_optin;
	}
	@FindBy(xpath="//input[@name=\"search\"]") private WebElement searchbtn;
	@FindBy(xpath="//a[text()='ABC_PARK123']") private WebElement contact_optin;
	
	public OrganizationPopup(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
