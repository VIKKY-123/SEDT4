package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Org_page {


	WebDriver driver;

	@FindBy(xpath="//input[@name=\"accountname\"]") private WebElement orgtextfield;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]") private WebElement org_save_btn;

	@FindBy(xpath="//select[@name=\"industry\"]") private WebElement industryDD;
	@FindBy(xpath="//select[@name=\"rating\"]") private WebElement ratingDD;
	public WebElement getAccounttypeDD() {
		return accounttypeDD;
	}
	@FindBy(xpath="//select[@name=\"accounttype\"]") private WebElement accounttypeDD;



	public WebElement getIndustryDD() {
		return industryDD;
	}
	public WebElement getRatingDD() {
		return ratingDD;
	}
	public WebElement getOrgtextfield() {
		return orgtextfield;
	}
	public WebElement getOrg_save_btn() {
		return org_save_btn;
	}
	public Create_Org_page(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	




}
