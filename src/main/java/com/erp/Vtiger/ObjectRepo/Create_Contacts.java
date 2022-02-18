package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Contacts {
	
	WebDriver driver;
	@FindBy(xpath="//select[@name=\"salutationtype\"]") private WebElement salutationDD;
	@FindBy(xpath="//input[@name=\"firstname\"]") private WebElement firstnametext;
	@FindBy(xpath="//input[@name=\"lastname\"]") private WebElement lastnametext;
	@FindBy(xpath="//input[@name=\"account_name\"]/../img") private WebElement accountnamebtn;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]") private WebElement savebtn;

	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getFirstnametext() {
		return firstnametext;
	}

	public WebElement getLastnametext() {
		return lastnametext;
	}

	public WebElement getAccountnamebtn() {
		return accountnamebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public Create_Contacts(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
