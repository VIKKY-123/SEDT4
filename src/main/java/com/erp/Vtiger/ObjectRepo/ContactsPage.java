package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@title=\"Create Contact...\"]") private WebElement create_contact;
	@FindBy(xpath="//input[@class=\"txtBox\"]") private WebElement txtbox;
	@FindBy(xpath="//select[@id=\"bas_searchfield\"]") private WebElement searchfield;
	@FindBy(xpath="//input[@name=\"submit\"]") private WebElement submitbtn;
	public WebElement getCreate_contact() {
		return create_contact;
	}
	public WebElement getTxtbox() {
		return txtbox;
	}
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
